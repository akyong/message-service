package message.service.services;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import message.service.domain.Permission;
import message.service.domain.ResponseModel;
import message.service.jackson.ListPrice;
import message.service.jackson.ListPriceSupDetail;
import message.service.jackson.PriceDetail;
import message.service.repository.ItemRepository;
import message.service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    @Named("default")
    DataSource dataSource;

    @Inject
    @Named("maintokdis")
    DataSource dataSourceTokdis;

    private ItemRepository itemRepository;
    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ItemRepository itemRepository, @CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public String formulaUpdateAll(String supplier_code, @NotNull List<Integer> categoryId) {
        ResponseModel rs = new ResponseModel();
        Connection con = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement;

        String categoryIdx = getInId(categoryId);

        try {
            con = dataSourceTokdis.getConnection();
            preparedStatement = con.prepareStatement("SELECT id FROM product_details WHERE sub_menucategory_id in "+categoryIdx);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                int product_id = resultSet.getInt("id");
                int priceRow = 0, urut = -1, urutSup = 0;
                boolean ket;
                Long priceId = null;
                String supplierCode = null;

                ListPrice listAgen = new ListPrice();
                ListPriceSupDetail listAgenS = new ListPriceSupDetail();
                LOG.info("product _id : {}",product_id);
                int price = itemRepository.findByPriceId(product_id);
                ket = false;

                LOG.info("HARGA : " + price);
                //for(int l = 0 ; l< categoryId.size(); l++){
                List<Permission> permissionList = findAllByCategoryIdList(categoryIdx);//satu row ini, kamu dibawah gak usa melakukan 3x query untuk float a,b,c
                int size = permissionList.size();

                if(size >= 1) {
                    for(int i = 0; i < size; i++){
                        supplierCode = permissionList.get(i).getSupplierCode();
//                        LOG.info("IDTEST : " + permissionList.get(i).getId());
                        if(supplierCode != null) {
                            if (supplierCode.equals(supplier_code)) {
                                urutSup = i;
                                ket = true;
                                break;
                            }
                        } else{
                            urut =i;
                        }
                    }
                }


                if (!permissionList.isEmpty()) {
                    for (int z = 0; z < permissionList.get(urut).getFormulaHeader().getFormulaDetailPriceList().size() ; z++) {
//                        LOG.info("category id : " + categoryId + " harga : " + price);

                        float fr = permissionList.get(urut).getFormulaHeader().getFormulaDetailPriceList().get(z).getPriceFrom();
                        float to = permissionList.get(urut).getFormulaHeader().getFormulaDetailPriceList().get(z).getPriceTo();

                        if (fr <= price && price <= to) {

                            priceRow = z;
                            priceId = permissionList.get(urut).getFormulaHeader().getFormulaDetailPriceList().get(z).getId();
                            Query queryHarga = entityManager.createQuery("SELECT g.minQty, g.markupPrice, g.agentCommision, g.discountMember, g.officialCommision FROM FormulaDetailQty as g WHERE g.formulaDetailPrice.id = :priceId").setParameter("priceId", priceId);

                            for (int j = 0; j < 6; j++) {
                                Object[] rows = (Object[]) queryHarga.getResultList().get(j);
                                float min = permissionList.get(urut).getFormulaHeader().getFormulaDetailPriceList().get(priceRow).getFormulaDetailQtyList().get(j).getMinQty();

                                int markup = Math.round(price * (float) rows[1]);
                                int agentCommision = Math.round(price * (float) rows[2]);
                                int diskonMember = Math.round(price * (float) rows[3]);
                                int official =  Math.round(price * (float) rows[4]);
                                int totalMarkup = agentCommision + diskonMember + official;
                                if (markup != totalMarkup){
                                    markup =  price + totalMarkup;
                                }else{
                                    markup = markup + price;
                                }

                                PriceDetail priceDetailA = new PriceDetail();
                                priceDetailA.setQty((int) rows[0]);
                                priceDetailA.setMarkupPrice(markup);
                                priceDetailA.setAgentCommision(agentCommision);
                                priceDetailA.setDiscountMember(markup - diskonMember);
                                listAgen.addListPrice(priceDetailA);
                            }
                            break;
                        }

                    }
                    if (ket == true) {
                        for (int z = 0; z < permissionList.get(urutSup).getFormulaHeader().getFormulaDetailPriceList().size() ; z++) {
//                            LOG.info("category id : " + categoryId + " harga : " + price);

                            float fr = permissionList.get(urutSup).getFormulaHeader().getFormulaDetailPriceList().get(z).getPriceFrom();
                            float to = permissionList.get(urutSup).getFormulaHeader().getFormulaDetailPriceList().get(z).getPriceTo();

                            if (fr <= price && price <= to) {
                                priceRow = z;
                                priceId = permissionList.get(urutSup).getFormulaHeader().getFormulaDetailPriceList().get(z).getId();
                                Query queryHarga = entityManager.createQuery("SELECT g.minQty, g.markupPrice, g.agentCommision, g.discountMember, g.officialCommision FROM FormulaDetailQty as g WHERE g.formulaDetailPrice.id = :priceId").setParameter("priceId", priceId);

                                for (int j = 0; j < 6; j++) {
                                    Object[] rows = (Object[]) queryHarga.getResultList().get(j);
                                    float min = permissionList.get(urutSup).getFormulaHeader().getFormulaDetailPriceList().get(priceRow).getFormulaDetailQtyList().get(j).getMinQty();

                                    int markup = Math.round(price * (float) rows[1]);
                                    int agentCommision = Math.round(price * (float) rows[2]);
                                    int diskonMember = Math.round(price * (float) rows[3]);
                                    int official =  Math.round(price * (float) rows[4]);
                                    int totalMarkup = agentCommision + diskonMember + official;
                                    if (markup != totalMarkup){
                                        markup =  price + totalMarkup;
                                    }else{
                                        markup = markup + price;
                                    }

                                    PriceDetail priceDetailAS = new PriceDetail();
                                    priceDetailAS.setQty((int) rows[0]);
                                    priceDetailAS.setMarkupPrice(markup);
                                    priceDetailAS.setAgentCommision(agentCommision);
                                    priceDetailAS.setDiscountMember(markup - diskonMember);
                                    listAgenS.addListPrice(priceDetailAS);

                                }
                                listAgenS.setSupplier_code(supplier_code);
                                listAgen.addListSupplier(listAgenS);
                                break;
                            }
                        }
                    }
                    else{
                        supplier_code = "";
                    }
                    rs.setCode(200);
                    rs.setCodeMessage("Success");
                    rs.setCodeType("success");
                } else {
                    rs.setCode(400);
                    rs.setCodeMessage("Permission Not Found");
                    rs.setCodeType("permission not found");
                }
                //LOG.info("urut : " + urut + " urutsup : "+urutSup+"status : " + ket + "supplier code : " + supplier_code);
                updateProductDetail(product_id, listAgen);

            }
            //}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) resultSet.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rs.toString();
    }



    public List<Permission>  findAllByCategoryIdList(@NotNull String categoryId){
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        List<Permission> permissionIdList = new ArrayList<>();
        LOG.info("castegoriid ===== {}",categoryId);

        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement("SELECT DISTINCT permissions.* FROM permissions INNER JOIN formula_header a ON permissions.formula_id = a.id, JSON_TABLE(sub_category, '$[*]' COLUMNS(nr INT PATH '$')) as ids  where ids.nr  in "+categoryId+" AND a.is_deleted = 0 AND permissions.is_deleted = 0");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                permissionIdList.add(getPermission(resultSet.getLong("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return permissionIdList;
    }

    public Permission getPermission(Long idpermission){
        Permission permission = entityManager.find(Permission.class, idpermission);
        return permission;
    }

    public String getInId(List<Integer> listid){
        String id = "(";
        for(int a = 0 ; a< listid.size(); a++){
            if(a == listid.size()-1){
                id = id+listid.get(a);
                id = id+")";
            }
            else{
                id = id+listid.get(a);
                id = id+",";
            }
        }
        return id;
    }

    public void  updateProductDetail(@NotNull int product_id, @NotNull ListPrice listAgen){
        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement;

        try {
            con = dataSourceTokdis.getConnection();
            preparedStatement = con.prepareStatement("UPDATE product_details SET rfc_price = ? where id = ?");
            preparedStatement.setString(1,listAgen.toString());
            preparedStatement.setInt(2,product_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

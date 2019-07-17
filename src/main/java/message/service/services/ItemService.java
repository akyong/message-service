package message.service.services;

import io.micronaut.spring.tx.annotation.Transactional;
import message.service.jackson.ProductDetail;
import message.service.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemService implements ItemRepository {
    @Inject
    @Named("maintokdis")
    DataSource dataSource;

    private Logger LOG = LoggerFactory.getLogger(ItemService.class);

//    public void updateToTokdis(int id){//contoh query untuk update.
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            con = dataSource.getConnection();
//            preparedStatement = con.prepareStatement("update order_summaries set payment_status = ? , " +
//                    "payment_verified_by = ? , payment_verified_at = ? , is_paid = ? where id = ?");
//            preparedStatement.setInt(1,1);
//            preparedStatement.setInt(2,0); //0 => system;
//            preparedStatement.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
//            preparedStatement.setInt(4, 1);
//            preparedStatement.setInt(5, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

//    @Override
//    @Transactional
//    public List<HashMap> findProductNameQtyPriceByProductId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        List<HashMap> listPriceQtyName = new ArrayList<>();
//        ProductDetail productDetail = new ProductDetail();
//
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.price->'$[0].price' as price, a.price->'$[0].qty' as qty, a.product_name,sub_menucategory_id from product_details a WHERE a.id = ? AND a.is_deleted = 0 AND a.price != \"\" LIMIT 20");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                HashMap map = new HashMap();
//                map.put("price", resultSet.getInt("price"));
//                map.put("qty", resultSet.getInt("qty"));
//                map.put("product_name", resultSet.getString("product_name"));
//                map.put("sub_menucategory_id", resultSet.getInt("sub_menucategory_id"));
//                listPriceQtyName.add(map);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return listPriceQtyName;
//    }

    @Override
    @Transactional
    public int findByPriceId(@NotNull int id){
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        int priceId = 0;

        try {
            con = dataSource.getConnection(); //koneksi ke DB
            preparedStatement = con.prepareStatement("select a.price->'$[0].price' as price from product_details a WHERE a.id = ? AND a.is_deleted = 0 AND a.price != \"\" LIMIT 20");
            preparedStatement.setInt(1, Math.toIntExact(id));
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                priceId = resultSet.getInt("price");
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
        return priceId;
    }


//    @Override
//    public int findByQtyId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        int qtyId = 0;
//        ProductDetail productDetail = new ProductDetail();
//        /*
//         * TODO select order_summaries
//         * parameter total_amount -> amount
//         * parameter is_paid -> 0 yang belum bayar
//         * */
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.price->'$[0].qty' as qty from product_details a WHERE a.id = ? AND a.is_deleted = 0 AND a.price != \"\" LIMIT 20");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                qtyId = resultSet.getInt("qty");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return qtyId;
//    }

//    @Override
//    public int findByCategoryByProductId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        int categoryId = 0;
//
//        /*
//         * TODO select order_summaries
//         * parameter total_amount -> amount
//         * parameter is_paid -> 0 yang belum bayar
//         * */
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.sub_menucategory_id from product_details a WHERE a.id = ? AND a.is_deleted = 0");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                categoryId = resultSet.getInt("sub_menucategory_id");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return categoryId;
//    }

//    @Override
//    @Transactional
//    public List<HashMap> findByListImageByProductId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        List<HashMap> categoryId = new ArrayList<>();
//
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.url from product_images a WHERE a.product_details_id = ? AND a.is_deleted = 0 order by a.sequence asc , id desc");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                HashMap map = new HashMap();
//                map.put("url", resultSet.getString("url"));
//                categoryId.add(map);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return categoryId;
//    }

//    @Override
//    @Transactional
//    public List<HashMap> findListImageVarianByProductId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        List<HashMap> categoryId = new ArrayList<>();
//
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.image, a.quantity, a.variant_descriptions from product_variation_details a WHERE a.product_details_id = ? AND a.is_deleted = 0");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                HashMap map = new HashMap();
//                map.put("image",resultSet.getString("image"));
//                map.put("quantity",resultSet.getInt("quantity"));
//                map.put("variant_description", resultSet.getString("variant_descriptions"));
//                categoryId.add(map);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return categoryId;
//    }

//    @Override
//    @Transactional
//    public List<HashMap> findDescriptionsByProductId(@NotNull int id){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        List<HashMap> categoryId = new ArrayList<>();
//
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("select a.id, a.price->'$[0].price' as price, a.main_menu_id,a.sub_menu_id, a.sub_menucategory_id, a.product_description, a.product_weight, a.total_sold, a.total_view_non_login, a.supplier_id, b.regencies_name, c.shop_img, c.shop_name, d.shipping_vendor_name from product_details a INNER JOIN tokdis_suppliers.suppliers_address b INNER JOIN tokdis_suppliers.suppliers_profile c INNER JOIN tokdis_suppliers.suppliers_shipping_vendors d ON b.supplier_id = a.supplier_id = c.id = d.supplier_id WHERE a.id = ? AND a.is_deleted = 0");
//            preparedStatement.setInt(1, Math.toIntExact(id));
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                HashMap map = new HashMap();
//                map.put("normal_price",resultSet.getInt("price"));
//                map.put("main_menu_id",resultSet.getInt("main_menu_id"));
//                map.put("sub_menu_id", resultSet.getInt("sub_menu_id"));
//                map.put("sub_menucategory_id",resultSet.getString("sub_menucategory_id"));
//                map.put("product_description",resultSet.getString("product_description"));
//                map.put("product_weight", resultSet.getInt("product_weight"));
//                map.put("total_sold",resultSet.getInt("total_sold"));
//                map.put("total_view_non_login",resultSet.getInt("total_view_non_login"));
//                map.put("regencies_name", resultSet.getString("regencies_name"));
//                map.put("shop_img", resultSet.getString("shop_img"));
//                map.put("shop_name",resultSet.getString("shop_name"));
//                map.put("shipping_vendor_name",resultSet.getString("shipping_vendor_name"));
//                categoryId.add(map);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return categoryId;
//    }
//
//    @Override
//    @Transactional
//    public List<HashMap> findListMemberByReferralCode(@NotNull String referral_code){
//        Connection con = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement;
//        List<HashMap> listMember = new ArrayList<>();
//
//        try {
//            con = dataSource.getConnection(); //koneksi ke DB
//            preparedStatement = con.prepareStatement("SELECT a.member_code, a.fullname, a.created FROM reseller a WHERE a.referral_code = ? ");
//            preparedStatement.setString(1, referral_code);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                HashMap map = new HashMap();
//                map.put("fullname",resultSet.getString("fullname"));
//                map.put("tanggal_bergabung",resultSet.getTimestamp("created"));
//                map.put("member_code", resultSet.getString("member_code"));
//                listMember.add(map);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(resultSet != null) resultSet.close();
//                if(statement != null) statement.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return listMember;
//    }
//
//    @Override
//    @Transactional
//    public HashMap findMemberByMemberCode(@NotNull String membercode){
//        ResultSet resultSet = null;
//        HashMap map = new HashMap();
//        try
//            (
//                Connection con = dataSource.getConnection(); //koneksi ke DB
//                PreparedStatement preparedStatement = con.prepareStatement("SELECT a.member_code, a.fullname, a.created FROM reseller a WHERE a.member_code = ? ");
//            )
//        {
//
//            preparedStatement.setString(1, membercode);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                map.put("fullname",resultSet.getString("fullname"));
//                map.put("tanggal_bergabung", resultSet.getTimestamp("created"));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
}
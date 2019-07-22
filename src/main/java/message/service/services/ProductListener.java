package message.service.services;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import message.service.helper.FormulaUpdate;
import message.service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class ProductListener {
    private final ProductRepository productRepository;

    public ProductListener(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    private Logger LOG = LoggerFactory.getLogger(ProductListener.class);

    @Topic("my-products001")
    public void receive1(FormulaUpdate formulaUpdate) {
        String now = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
//        LOG.info("supplier ocde : {}", supplier_code != null ? supplier_code : "suppliercode null");
//        LOG.info("list Category Id = {}",categoryId);
        LOG.info("{} : --------------------- {}", now, "START UPDATE PRODUCT");
//        String supplier_code = null;
        productRepository.formulaUpdateAll(formulaUpdate.getSupplierCode(),formulaUpdate.getCategoryId());
        LOG.info("{} : --------------------- {}", now, "END UPDATE PRODUCT");

    }

    @Topic("my-products002")
    public void receive2(FormulaUpdate formulaUpdate) {
        String now = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
//        LOG.info("supplier ocde : {}", supplier_code != null ? supplier_code : "suppliercode null");
//        LOG.info("list Category Id = {}",categoryId);
        LOG.info("{} : --------------------- {}", now, "START UPDATE PRODUCT");
//        String supplier_code = null;
        productRepository.formulaUpdateAll(formulaUpdate.getSupplierCode(),formulaUpdate.getCategoryId());
        LOG.info("{} : --------------------- {}", now, "END UPDATE PRODUCT");

    }
    @Topic("my-products003")
    public void receive3(FormulaUpdate formulaUpdate) {
        String now = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
//        LOG.info("supplier ocde : {}", supplier_code != null ? supplier_code : "suppliercode null");
//        LOG.info("list Category Id = {}",categoryId);
        LOG.info("{} : --------------------- {}", now, "START UPDATE PRODUCT");
//        String supplier_code = null;
        productRepository.formulaUpdateAll(formulaUpdate.getSupplierCode(),formulaUpdate.getCategoryId());
        LOG.info("{} : --------------------- {}", now, "END UPDATE PRODUCT");

    }
}

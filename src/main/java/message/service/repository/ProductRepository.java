package message.service.repository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductRepository {
    String formulaUpdateAll(String supplier_code, @NotNull List<Integer> categoryId);
}

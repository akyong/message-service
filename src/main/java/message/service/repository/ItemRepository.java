package message.service.repository;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

public interface ItemRepository {

    int findByPriceId(@NotNull int id);
}
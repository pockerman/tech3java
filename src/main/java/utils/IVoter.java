package utils;

import java.util.List;

public interface IVoter<ItemType, CriterionType, ResultType> {

    void addItem(ItemType item, CriterionType criterionType);

    ResultType getResult();

}

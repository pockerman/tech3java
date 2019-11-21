package parallel.partitioners;

import java.util.List;

public interface IPartitionePolicy {

    List<Integer> getParition(int i);
}

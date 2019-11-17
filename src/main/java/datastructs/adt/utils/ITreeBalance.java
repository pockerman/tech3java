package datastructs.adt.utils;

/**
 * General interface for providing balancing algorithms for trees
 */
public interface ITreeBalance {

    <NodeType> void balance(NodeType node);
}

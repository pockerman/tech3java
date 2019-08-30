package utils;



public class DfsInsertStrategy implements ITreeInsertStrategy {

    @Override
    public final TreeInsertMethod type(){return TreeInsertMethod.DFS; }

    @Override
    public final <DataTp> boolean  insert(TreeNode<DataTp> root, TreeNode<DataTp> parent, DataTp data, IPredicate<TreeNode<DataTp>> insertPosPredicate){

        return doInsert(root,  parent, data, insertPosPredicate).first;
    }


    private final <DataTp> Pair<Boolean, TreeNode<DataTp>> doInsert(TreeNode<DataTp> root, TreeNode<DataTp> parent,
                                                                    DataTp data, IPredicate<TreeNode<DataTp>> insertPosPredicate){

        TreeNodeCreator<DataTp> creator = new TreeNodeCreator<>();
        utils.Pair<Boolean, TreeNode<DataTp>> rslt = PairCreator.makePair(false, null);

        if(insertPosPredicate.satisfies(root)){

            if(root != null){
                root.setData(data);
            }
            else {

                if (parent == null) {
                    root = creator.create(data, null, -1, -1);
                }
                else {
                    root = creator.create(data, parent, parent.getLevel()+1, parent.getNChildren());
                }

                rslt.first = true;
                rslt.second= root;
            }
        }
        else{

            for(int c = 0; c<root.getNChildren(); ++c){

                rslt = doInsert(root.getChild(c), root, data, insertPosPredicate);

                if(rslt != null && rslt.first && rslt.second != null){

                    root.setChild(c, rslt.second);
                    rslt.second = null;

                    break;
                }
            }
        }

        return rslt;
    }
}

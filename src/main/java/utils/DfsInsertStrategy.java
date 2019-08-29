package utils;



public class DfsInsertStrategy implements ITreeInsertStrategy {

    public final <DataTp> boolean  insert(TreeNode<DataTp> root, TreeNode<DataTp> parent, DataTp data, IPredicate<TreeNode<DataTp>> insertPosPredicate){

        return doInsert(root,  parent, data, insertPosPredicate).first;
    }


    private final <DataTp> Pair<Boolean, TreeNode<DataTp>> doInsert(TreeNode<DataTp> root, TreeNode<DataTp> parent, DataTp data,
                                         IPredicate<TreeNode<DataTp>> insertPosPredicate){

        TreeNodeCreator<DataTp> creator = new TreeNodeCreator<>();
        boolean done = false;
        utils.Pair<Boolean, TreeNode<DataTp>> rslt = null;

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

                done = true;
                rslt = PairCreator.makePair(done, root);

            }
        }
        else{

            for(int c = 0; c<root.getNChildren(); ++c){
                TreeNode<DataTp> node = root.getChild(c);
                rslt = doInsert(node, root, data, insertPosPredicate);

                if(rslt != null && rslt.first){
                    root.setChild(c, rslt.second);
                    break;
                }
            }
        }

        return rslt;
    }



}

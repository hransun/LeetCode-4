public int solution(TreeNode T) {
        Cell cell = helper(T);
        return (int)Math.pow(2, cell.height)-1;

    }
    private Cell helper(TreeNode T){
        Cell cell = new Cell();
        if(T == null){
            cell.height =0;
            cell.isPerfect = true;
            return cell;
        }
        Cell left = helper(T.left);
        Cell right = helper(T.right);
        if(left.isPerfect && right.isPerfect){
            cell.isPerfect = true;
            cell.height = Math.min(left.height, right.height) + 1;
        }else if(left.isPerfect){
            cell.height = left.height;
        }else if(right.isPerfect){
            cell.height = right.height;
        }
        return cell;

    }
    class Cell{
        int height = 0;
        boolean isPerfect = false;

    }

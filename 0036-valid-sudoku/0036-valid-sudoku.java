class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<9; i++){
            Set<Character> st = new HashSet<>();
            for(int j=0; j<9; j++){

                char x = board[i][j];

                if(x =='.'){
                    continue;
                }

                if(!st.contains(x)){
                    st.add(x);
                }
                else{
                    return false;
                }
            }
        }

        for(int i=0; i<9; i++){
            Set<Character> st = new HashSet<>();
            for(int j=0; j<9; j++){

                char x = board[j][i];

                if(x =='.'){
                    continue;
                }

                if(!st.contains(x)){
                    st.add(x);
                }
                else{
                    return false;
                }
            }
        }

        Set<String> setu = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char x = board[i][j];

                if(x=='.'){
                    continue;
                }

                if(!setu.contains(x+"at"+i/3+j/3)){
                    setu.add(x+"at"+i/3+j/3);
                }
                else{
                    return false;
                }
            }
        }
    return true;
    }
}
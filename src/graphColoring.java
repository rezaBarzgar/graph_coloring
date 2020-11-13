public class graphColoring {
    static int colorNumber = 1;
    static int currentVertex;
    static int [] vertexColor;
    static int [][] graph = new int[][]{{0,1,0,1},{1,0,1,1},{0,1,0,1},{1,1,1,0}};


    static void coloring(){
        vertexColor = new int[graph.length];
        vertexColor[0] = 1;
        currentVertex = findNext(0);
        while(!allColored()){
            vertexColor[currentVertex] = findColor(currentVertex);
            currentVertex = findNext(currentVertex);
        }
    }

    private static int findColor(int vertex) {
        int x=0;
        for (int i=0;i<graph.length;i++){
            if (graph[vertex][i] == 1 && vertexColor[i] >0){
                x++;
            }
        }
        if (x>=colorNumber){
            colorNumber = colorNumber +1;
            return colorNumber;
        }
        else {
            return findExactNumber(colorNumber , currentVertex);
        }
    }

    private static int findExactNumber(int colorNumber,int vertex) {
        int [] checkList = new int [colorNumber];
        for (int i=0;i<vertexColor.length;i++){
            if (vertexColor[i] >0 && graph[vertex][i] == 1){
                checkList[vertexColor[i] - 1] =1;
            }
        }
        for (int i=0;i<checkList.length;i++){
            if (checkList[i] == 0){
                return i+1;
            }
        }
        return 0;
    }

    private static boolean allColored() {
        for (int i=0;i<vertexColor.length;i++){
            if (vertexColor[i] == 0){
                return false;
            }
        }
        return true;
    }

    private static int findNext(int currentVertex) {
        if (currentVertex >= graph.length) {
            return -1;
        }
        for (int i=0;i<graph.length;i++){
            if (graph[currentVertex][i] == 1){
                if (vertexColor[i] == 0){
                    return i;
                }
            }
        }
        return findNext(currentVertex +1);
    }

    public static void main(String[] args) {
        coloring();
        System.out.println(colorNumber);
    }

}

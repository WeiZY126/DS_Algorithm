package Demo09Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Demo01Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数
    private boolean[] isVisited;//记录某个结点是否被访问

    public static void main(String[] args) throws Exception {
        int n = 5;//结点的个数
        String VertexValue[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Demo01Graph graph = new Demo01Graph(n);
        for (String s : VertexValue) {
            graph.insertVertex(s);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(4, 1, 1);
        graph.dfs();

    }

    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i第一次就是0
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将该结点设置为已经访问过
        isVisited[i] = true;
        //查找第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历所有的结点并dfs
    public void dfs() {
        //遍历所有的结点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个结点广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;//表示队列的头结点对应的下标
        int w;//表示邻接节点w
        //队列，节点访问顺序记录
        LinkedList quene = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        quene.addLast(i);
        while (!quene.isEmpty()) {
            //取出队列的头结点下标
            u = (int) quene.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {//找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(i) + "->");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    quene.addLast(w);
                } else {
                    //以u为前驱节点，找w后面的下一个邻接点
                    w = getNextNeighbor(u, w);//体现出广度优先
                }
            }
        }
    }

    /**
     * @param n 顶点个数
     */
    public Demo01Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i（下标）对应的数据 0->A B->2....
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int gerWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的邻接矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }

    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     点的下标,即第几个顶点
     * @param v2     第二个点的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

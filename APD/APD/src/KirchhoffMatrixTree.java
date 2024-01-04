import java.util.Arrays;
import java.util.Scanner;

public class KirchhoffMatrixTree {

    // Функция для вычисления определителя матрицы
    public static int determinant(int[][] matrix, int n) {
        int det = 0;
        if (n == 1) {
            return matrix[0][0];
        }
        int[][] temp = new int[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            getCofactor(matrix, temp, 0, f, n);
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }
        return det;
    }

    // Функция для получения кофактора матрицы (используется в определителе)
    public static void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // Функция для ввода матрицы смежности графа
    public static int[][] readGraph(Scanner scanner, int n) {
        int[][] graph = new int[n][n];
        System.out.println("Введите матрицу смежности графа:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        return graph;
    }

    // Функция для вычисления количества остовных деревьев с использованием матрицы Кирхгофа
    public static int numberOfSpanningTrees(int[][] graph) {
        int N = graph.length;
        int[][] laplacian = new int[N][N];

        // Вычисляем матрицу Лапласа
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    laplacian[i][j] = Arrays.stream(graph[i]).sum();
                } else {
                    laplacian[i][j] = -graph[i][j];
                }
            }
        }

        // Удаляем первую строку и первый столбец для вычисления минора
        int[][] minor = new int[N-1][N-1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                minor[i-1][j-1] = laplacian[i][j];
            }
        }

        // Вычисляем определитель минора
        return determinant(minor, N-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество вершин в графе: ");
        int n = scanner.nextInt();

        int[][] graph = readGraph(scanner, n);
        System.out.println("Количество остовных деревьев: " + numberOfSpanningTrees(graph));
    }
}

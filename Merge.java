public class Merge{
  public static void mergesort(int[] data){
    mergesorth(data, 0, data.length - 1);
  }
  private static void mergesorth(int[] data, int low, int high){
    if (low >= high){
      return;
    }
    int[] lary = new int[data.length / 2];
    System.out.println(lary.length);
    int[] hary = new int[data.length - (data.length / 2)];
    System.out.println(hary.length);
  }
  public static void main(String[] args){
    int[] data = {80, 60, 90, 50, 70};
    mergesort(data);
  }
  public static void merge(int[] data1, int[] data2){
    int l = 0;
    int h = 0;
    for (int i = 0; i < data1.length + data2.length; i++){
      if (l < data1.length && h < data2.length){
        if (data1[l] > data2[h]){
          
        }
      }
    }
  }
}

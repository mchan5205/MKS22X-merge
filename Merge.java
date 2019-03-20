import java.util.*;
public class Merge{
  public static void mergesort(int[] data){
    mergesorth(data, 0, data.length);
  }
  private static void mergesorth(int[] data, int low, int high){
    if (low >= high){
      return;
    }
    int[] lary;
    if ((high - low) % 2 == 0){
      lary = new int[(high - low) / 2];
    }
    else{
      lary = new int[(high - low) / 2 + 1];
    }
    int i = 0;
    while (i < lary.length){
      lary[i] = data[low + i];
      i++;
    }
    System.out.println(Arrays.toString(lary) + " lary");
    int[] hary = new int[(high - low) / 2];
    int h = 0;
    while (h < hary.length){
      hary[h] = data[low + i];
      h++;
      i++;
    }
    System.out.println(Arrays.toString(hary) + " hary");
    if (lary.length != 1){
      mergesorth(data, low, low + lary.length);
    }
    else{
      mergesorth(data, low, low);
    }
    mergesorth(data, low + lary.length , high);
    int o = 0;
    while (o < lary.length){
      lary[o] = data[low + o];
      o++;
    }
    int t = 0;
    while (t < hary.length){
      hary[t] = data[low + o];
      t++;
      o++;
    }
    merge(lary,hary,low,data);
    System.out.println(Arrays.toString(data));
  }
  public static void main(String[] args){
    int[] data = {38, 27, 43, 3, 9, 82, 10};
    System.out.println(Arrays.toString(data));
    mergesort(data);
    System.out.println(Arrays.toString(data));
  }
  public static void merge(int[] data1, int[] data2, int low, int[] data){
    int l = 0;
    int h = 0;
    for (int i = 0; i < data1.length + data2.length; i++){
      if (l < data1.length && h < data2.length){
        if (data1[l] > data2[h]){
          data[low + i] = data2[h];
          h += 1;
        }
        else{
          data[low + i] = data1[l];
          l += 1;
        }
      }
      else if (l < data1.length){
        data[low + i] = data1[l];
        l += 1;
      }
      else{
        data[low + i] = data2[h];
        h += 1;
      }
    }
  }
}

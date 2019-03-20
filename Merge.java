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
    //System.out.println(Arrays.toString(lary) + " lary");
    int[] hary = new int[(high - low) / 2];
    int h = 0;
    while (h < hary.length){
      hary[h] = data[low + i];
      h++;
      i++;
    }
    if (high - low < 10){
      insertionSort(lary);
      insertionSort(hary);
      merge(lary,hary,low,data);
      return;
    }
    //System.out.println(Arrays.toString(hary) + " hary");
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
    //System.out.println(Arrays.toString(data));
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Merge.mergesort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
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
  public static void insertionSort(int[] ary){
    for (int i = 0; i < ary.length; i++){
      int temp = ary[i];
      int x = i - 1;
      boolean done = false;
      while (x >= 0 && ! done){
        if (ary[x] > temp){
          ary[x + 1] = ary[x];
          x = x - 1;
        }
        else{
          done = true;
        }
      }
      ary[x + 1] = temp;
    }
  }
}

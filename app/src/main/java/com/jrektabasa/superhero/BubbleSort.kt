package com.jrektabasa.superhero


fun main() {

    val numbers = mutableListOf<Int>(5, 2, 6, 3, 8, 0)
    bubbleSort(numbers)

    print(numbers)
}

fun bubbleSort(numbs: MutableList<Int>) {
    val n = numbs.size

    for(i in 0 until n - 1){
        for(j in 0 until n - i - 1){
           if(numbs[j] > numbs[j + 1]){
               val temp = numbs[j]
               //swap
               numbs[j] = numbs[j + 1]
               numbs[j + 1] = temp
           }
        }
    }


//    void bubbleSort(List<int> list) {
//        int listLength = list.length;
//
//        for (int i = 0; i < listLength - 1; i++) {
//        print('j-i-1: ${listLength - i - 1}');
//        for (int j = 0; j < listLength - i - 1; j++) {
//        if (list[j] > list[j + 1]) {
//            int temp = list[j];
//
//            list[j] = list[j + 1];
//
//            list[j + 1] = temp;
//        }
//    }
//    }
//    }
}

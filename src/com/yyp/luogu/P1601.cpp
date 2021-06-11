#include<bits/stdc++.h>
#include<iostream>
#include<string>
using namespace std;

//初始化为0
int a[501], b[501], sum[501];
int main(){
    string string_num;
    cin >> string_num;
    int index = 0;
    //倒序存储 便于处理
    for(int i = string_num.size() - 1; i >= 0; i--){
        a[index++] = string_num[i] - '0';
    }
    int a_size = string_num.size();
    cin >> string_num;
    index = 0;
    for(int i = string_num.size() - 1; i >= 0; i--){
        b[index++] = string_num[i] - '0';
    }
    int b_size = string_num.size();
    int size = a_size > b_size ? a_size : b_size;//获得较长数组的size
    //进位
    int carry = 0;
    for(int i = 0; i < size; i++){
        int temp = a[i] + b[i] + carry;
        if(temp >= 10){//相加值大于等于10， 进位为1， 当前位为temp - 10
            carry = 1;
            sum[i] = temp - 10;
        }else{
            sum[i] = temp;
            carry = 0;//重置进位
        }
    }
    if(carry > 0){//最后还有进位
        sum[size] = carry;
        for(int i = size; i >= 0; i--){
            printf("%d", sum[i]);
        }
    }else{//最后无进位
        for(int i = size - 1; i >= 0; i--){
            printf("%d", sum[i]);
        }
    }

    return 0;
}
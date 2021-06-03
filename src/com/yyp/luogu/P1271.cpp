#include<bits/stdc++.h>
using namespace std;
int main()
{
    //a[2000001]
    //注意数组范围，不要开小了
    int a[200], n, m;
    scanf("%d%d", &n, &m);
    for(int i = 1; i <= m; i++){
        scanf("%d", &a[i]);
    }
    sort(a+1, a+m+1);
    for(int i = 1; i <= m; i++){
        if(i == m){
            printf("%d", a[i]);
        }else{
            printf("%d ", a[i]);
        }
    }
    return 0;
}
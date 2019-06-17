#include<stdio.h>
#include<stdlib.h>
//Average case Time Complexity = 0(n.log n)
//Worst Case Time Complexity = O(n^2)
//Average case space Complexity = 0(log n)
//Worst case space Complexity = O(n)
void quick_sort(int A[],int p,int r);


//Worst case space Complexity = O(1)
//Worst case time complexity = O(n)
int partition(int A[],int p,int r);
int main()
{
    int n,i;
    printf("Enter no. of elements: ");
    scanf("%d",&n);
    int *A=(int*)malloc(n*sizeof(int));
    if(A==NULL)
    {
        printf("\nMemory can't be allocated\n");
        exit(0);
    }
    for(i=0;i<=n-1;i++)
    {
        printf("Enter A[%d] ",i);
        scanf("%d",A+i);
    }
    printf("\nArray:-\n");
    for(i=0;i<=n-1;i++)
        printf("%d ",*(A+i));
    quick_sort(A,0,n-1);
    printf("\nSorted Array:-\n");
    for(i=0;i<=n-1;i++)
        printf("%d ",*(A+i));
    return 0;
}
int partition(int A[],int p,int r)
{
    int i,j,pivot,temp;
    i=p-1;
    pivot=A[r];
    for(j=p;j<=r-1;j++)
    {
        if(A[j]<=pivot)
        {
            i++;
            temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
    }
    temp=A[i+1];
    A[i+1]=A[r];
    A[r]=temp;
    return i+1;
}
void quick_sort(int A[],int p,int r)
{
    int q;
    if(p<r)
    {
        q=partition(A,p,r);
        quick_sort(A,p,q-1);
        quick_sort(A,q+1,r);
    }
}

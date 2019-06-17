#include<stdio.h>
#include<stdlib.h>
int binary_search(int A[],int n,int target);
int partition(int A[],int p,int r);
void quick_sort(int A[],int p,int r);
int main(void)
{
    int n,target,i;
    printf("Enter no. of elements: ");
    scanf("%d",&n);
    int *A=(int*)malloc(n*sizeof(int));
    if(A==NULL)
    {
        printf("\nMemory can't be allocated\n");
        exit(1);
    }
    for(i=0;i<=n-1;i++)
    {
        printf("Enter a[%d] ",i);
        scanf("%d",&A[i]);
    }
    printf("\nArray:-\n");
    for(i=0;i<=n-1;i++)
        printf("%d ",A[i]);
    printf("\nEnter the element to be searched: ");
    scanf("%d",&target);
    int check=binary_search(A,n,target);
    if(check==1)
        printf("\n%d is found\n",target);
    else
        printf("\n%d is not found\n",target);
    return 0;
}
int binary_search(int A[],int n,int target)
{
    int l,r,mid;
    quick_sort(A,0,n-1);
    l=0;
    r=n-1;
    while(l<=r)
    {
        mid=(l+r)/2;
        if(A[mid]==target)
            return 1;
        else if(A[mid]<target)
            l=mid+1;
        else
            r=mid-1;
    }
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

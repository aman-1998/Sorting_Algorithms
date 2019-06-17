#include<stdio.h>
#include<stdlib.h>
void merge_sort(int a[],int p,int r);
void merge(int a[],int p,int q,int r);
int main()
{
    int n,i;
    printf("Enter no. of elements to be sorted: ");
    scanf("%d",&n);
    int *a=(int*)malloc(n*sizeof(int));
    if(a==NULL)
    {
        printf("\nMemory can't be allocated\n");
        exit(1);
    }
    for(i=0;i<=n-1;i++)
    {
        printf("Enter a[%d] ",i);
        scanf("%d",a+i);
    }
    printf("\nArray:-\n");
    for(i=0;i<=n-1;i++)
        printf("%d ",a[i]);
    merge_sort(a,0,n-1);
    printf("\nSorted Array:-\n");
    for(i=0;i<=n-1;i++)
        printf("%d ",*(a+i));
    return 0;
}
void merge_sort(int a[],int p,int r)
{
    int q;
    if(p<r)
    {
        q=(p+r)/2;
        merge_sort(a,p,q);
        merge_sort(a,q+1,r);
        merge(a,p,q,r);
    }
}
void merge(int a[],int p,int q,int r)
{
    int n1,n2,i,j,k;
    n1=q-p+1;
    n2=r-q;
    int *L=(int*)malloc((n1+1)*sizeof(int));
    int *R=(int*)malloc((n2+1)*sizeof(int));
    for(i=0;i<=n1-1;i++)
        L[i]=a[p+i];
    for(i=0;i<=n2-1;i++)
        R[i]=a[q+i+1];
    L[n1]=(1<<31)-1;
    R[n2]=(1<<31)-1;
    i=0;
    j=0;
    for(k=p;k<=r;k++)
    {
        if(L[i]<R[j])
        {
            a[k]=L[i];
            i++;
        }
        else
        {
            a[k]=R[j];
            j++;
        }
    }
}

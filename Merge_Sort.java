import java.util.Scanner;
class Merge_Sort
{
	void merge_sort(int A[],int p,int r)
	{
		int q;
		Merge_Sort ob=new Merge_Sort();
		if(p<r)
		{
			q=(p+r)/2;
			ob.merge_sort(A,p,q);
			ob.merge_sort(A,q+1,r);
			ob.merge(A,p,q,r);
		}
	}
	void merge(int A[],int p,int q,int r)
	{
		int n1,n2,i,j,k;
		n1=q-p+1;
		n2=r-q;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		for(i=0;i<=n1-1;i++)
			L[i]=A[p+i];
		for(i=0;i<=n2-1;i++)
			R[i]=A[q+i+1];
		L[n1]=(1<<31)-1;
		R[n2]=(1<<31)-1;
		i=0;
		j=0;
		for(k=p;k<=r;k++)
		{
			if(L[i]<R[j])
			{
				A[k]=L[i];
				i++;
			}
			else
			{
				A[k]=R[j];
				j++;
			}
		}
	}
	public static void main(String args[])
	{
		int n,i;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		n=in.nextInt();
		int A[];
		A=new int[n];
		for(i=0;i<=A.length-1;i++)
		{
			System.out.print("Enter a["+i+"] ");
			A[i]=in.nextInt();
		}
		System.out.print("\nArray:-\n");
		for(i=0;i<=A.length-1;i++)
			System.out.print(A[i]+" ");
		Merge_Sort obj=new Merge_Sort();
		obj.merge_sort(A,0,n-1);
		System.out.print("\nSorted Array:-\n");
		for(i=0;i<=A.length-1;i++)
			System.out.print(A[i]+" ");
	}
}
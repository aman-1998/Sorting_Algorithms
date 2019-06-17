import java.util.Scanner;
class Binary_Search_Using_Merge_Sort
{
	int binary_search(int A[],int target)
	{
		int l=0,r=A.length-1,mid;
		Binary_Search_Using_Merge_Sort obj=new Binary_Search_Using_Merge_Sort();
		obj.merge_sort(A,0,A.length-1);
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
	void merge_sort(int A[],int p,int r)
	{
		int q;
		Binary_Search_Using_Merge_Sort ob=new Binary_Search_Using_Merge_Sort();
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
		int target,n,i;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of elements: ");
		n=in.nextInt();
		int[] A=new int[n];
		for(i=0;i<=n-1;i++)
		{
			System.out.print("Enter A["+i+"] ");
			A[i]=in.nextInt();
		}
		System.out.print("\nArray:-\n");
		for(int j:A)
			System.out.print(j+" ");
		System.out.print("\nEnter the target element: ");
		target=in.nextInt();
		Binary_Search_Using_Merge_Sort ob=new Binary_Search_Using_Merge_Sort();
		// time
		int check=ob.binary_search(A,target);
		// complexity = O(nlog n)
		if(check==1)
			System.out.print(target+" is found\n");
		else
			System.out.print(target+" is not found\n");
	}
}
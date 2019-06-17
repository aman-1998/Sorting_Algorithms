import java.util.Scanner;
class Selection_Sort
{
	public static void main(String args[])
	{
		int n,i,j,pos=0,temp;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of  elements: ");
		n=in.nextInt();
		int[] a=new int[n];
		for(i=0;i<=n-1;i++)
		{
			System.out.print("Enter a["+i+"] ");
			a[i]=in.nextInt();
		}
		System.out.print("\nArray:-\n");
		for(i=0;i<=n-1;i++)
			System.out.print(a[i]+" ");
		//Selection sort
		for(i=0;i<=n-1;i++)
		{
			for(j=i+1;j<=n-1;j++)
			{
				if(a[j]<a[i])
					break;
			}
			if(j==n)
			{
				temp=a[i];
				a[i]=a[pos];
				a[pos]=temp;
				i=pos;
				pos++;
			}
		}
		System.out.print("\nSorted Array:-\n");
		for(i=0;i<=n-1;i++)
			System.out.print(a[i]+" ");
	}
}
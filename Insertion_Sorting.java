import java.util.Scanner;
class Insertion_Sorting
{
	public static void main(String args[])
	{
		int n,i,j,temp;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of elements to be sorted: ");
		n=in.nextInt();
		int[] a;
		a=new int[n];
		for(i=0;i<=a.length-1;i++)
		{
			System.out.print("Enter a["+i+"] ");
			a[i]=in.nextInt();
		}
		System.out.print("\nArray:-\n");
		for(i=0;i<=n-1;i++)
			System.out.print(a[i]+" ");
		//Insertion Sorting
		for(i=1;i<=n-1;i++)
		{
			j=i;
			temp=a[j];
			while(temp<a[j-1])
			{
				a[j]=a[j-1];
				j--;
				if(j==0)
					break;
			}
			a[j]=temp;
		}
		// End of sorting
		//Time Complexity = O(n^2)
		System.out.print("\nSorted Array:-\n");
		for(i=0;i<=n-1;i++)
			System.out.print(a[i]+" ");
	}
}
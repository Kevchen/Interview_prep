public class SumOfPrimes
{
	// 7 17 2+3+5+7
	public static int SumOfPrimesFunc(int n)
	{
		boolean[] isPrime = new boolean[n+1]; 
		for(int i=0; i<n+1;i++){
			isPrime[i]=true;
		}
		int count=0;
		for(int i=2;i<n+1;i++){
			//go through loop, if not in hm, then add to count
			if(isPrime[i]){
				System.out.println(i+"\n");
				count+=i;
			}
			int multiple=2;
			int temp = multiple*i;
			while(temp<=n){
				System.out.println(i+"removed\n");
				isPrime[temp]=false;
				temp=(++multiple)*i;
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		System.out.println(SumOfPrimesFunc(7));}
}


void shuffle(int*a ,int n)
{ 
   int i,t,n2=n*2;
   PerfectShuffle(a,n);
   for(i=2;i<=n2;i+=2)
   	{ 
  		t = a[i-1];
  		a[i-1] = a[i];
  		a[i] = t;
   	}
}



void CycleLeader(int* a,int from,int mod)
{
	int t,i;
	for(i=from*2%mod;i!=from;i=i*2%mod)
	{ 
		t=a[i];
		a[i]=a[from];
		a[from]=t;
	} 
}

void reverse(int *a, int from ,int to){ 
	int t;
	for(;from<to;++from,--to){ 
		t=a[from];
		a[from]=a[to];
		a[to] =t;
	}
}

void RightRotate(int *a,int m,int n)
{ 
	reverse(a,1,n-m);
	reverse(a,n-num+1,n);
	reverse(a,1,n);
}

void PerfectShuffle(int *a, int n)
{ 
	int n2, m, i, k, t;
	for(;n>1;){
	n2 = n*2;
	for(k=0,m=1;n2/m>=3;++k,m*=3);
	m =/ 2;
	RightRotate(a+m,m,n);
	for(i=0,t=1;i<k;++i,t*=3)
	{ 
		CycleLeader(a,t,m*2+1);
	}

	a += m*2;
	n -= m;
}
t=a[1];
a[1] = a[2];
a[2] = t;
}



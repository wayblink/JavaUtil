package MS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        
        int[] arr=new int[n];
        int c=0;
        int sum=0;
        while(c<n) {
            arr[c]=in.nextInt();
            sum+=arr[c];
            c++;
        }
        
        int yu=sum%3;
        if(yu==0){
            int i=0;
            int j=n-1;
            int sum_1=0;
            int sum_2=0;
            while(sum_1<sum/3){
                sum_1+=arr[i++];
            }
            if(sum_1!=sum/3){
                System.out.println(0);
                return;
            }
            while(sum_2<sum/3){
                sum_2+=arr[j--];
            }
            if(sum_2!=sum/3){
                System.out.println(0);
                return;
            }
            
            int l0=0,r0=0;
            while(arr[i]==0){
                l0++;
                i++;
            }
            while(arr[j]==0){
                r0++;
                j--;
            }
            int ans_num=(l0+1)*(r0+1);
            System.out.println(ans_num);
            return;
            
        }else if(yu==1){
            int ans_num=0;

            // 大  小  小
            int sum_1=0;
            int sum_2=0;
            int i=0;
            int j=n-1;
            while(sum_1<sum/3+1){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3+1){
                while(sum_2<sum/3){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }

            sum_1=0;
            sum_2=0;
            i=0;
            j=n-1;
            while(sum_1<sum/3){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3){
                while(sum_2<sum/3+1){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3+1){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }
            
            sum_1=0;
            sum_2=0;
            i=0;
            j=n-1;
            while(sum_1<sum/3){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3){
                while(sum_2<sum/3){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }
            
            System.out.println(ans_num);

        }else{
            int ans_num=0;

            int sum_1=0;
            int sum_2=0;
            int i=0;
            int j=n-1;
            while(sum_1<sum/3+1){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3+1){
                while(sum_2<sum/3+1){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3+1){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }

            sum_1=0;
            sum_2=0;
            i=0;
            j=n-1;
            while(sum_1<sum/3+1){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3+1){
                while(sum_2<sum/3){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }
            
            sum_1=0;
            sum_2=0;
            i=0;
            j=n-1;
            while(sum_1<sum/3){
                sum_1+=arr[i++];
            }
            if(sum_1==sum/3){
                while(sum_2<sum/3+1){
                    sum_2+=arr[j--];
                }
                if(sum_2==sum/3+1){
                    int l0=0,r0=0;
                    while(arr[i]==0){
                        l0++;
                        i++;
                    }
                    while(arr[j]==0){
                        r0++;
                        j--;
                    }
                    ans_num+=(l0+1)*(r0+1);
                }
            }
            
            System.out.println(ans_num); 
        }
    }
}
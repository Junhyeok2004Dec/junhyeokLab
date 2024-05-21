//<<프로그램 작성 문제>>
// 2023108316 JNU 최준혁
//
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>   
#define rateCalc(rate) rate++; // 물가상승률을 고려한 연봉상승률
#define rateEcono() (rand() %8 ) + 1; // 물가상승률



long int calcSalary(int rate, long int currentSalary) { 
	return (long)((1 + (rate / 100)) * currentSalary);// 연봉계산식
}

typedef struct PAY {  //연봉 정보 구조체
	long int salary;  //연봉
	int rate;		//인상률
} EARN;
typedef struct worker { //로동자 구조체

	char name[50]; //성명
	struct PAY pays[10]; // 10년간 받은 연봉 데이터
} WORKER;


	char* name[40] = { "홍렬" , "vladimir", "путин", "союз", "dlf"};

	for (int i = 0; i < 5; i++) {
		//5명에 관해 출력
		
		for (int j = 1; j <= 10; j++) {



			struct WORKER* worker = malloc(sizeof(struct WORKER));
			
			(staff + i) = &worker;
		
		}
		


	}
	


    /*
    for (int i = 0; i < 5; i++) {

        struct Person* worker = malloc(sizeof(struct Person));    // 구조체 포인터 선언, 메모리 할당

        



        strcpy(*worker->name, "홍길동");
        worker->earns[0].salary = 0;


        printf("\n이름을 입력하세요 : ");
        scanf_s("%s", *worker->name);

        printf("1");

        printf("\n협상된 연봉을 입력하세요 [1만원 단위] : ");
        scanf_s("%d", worker->earns[0].salary);

        


        for (int j = 1; j < 10; j++) {
            worker->earns[j].rate = *(&rate + j) + 1; //물가인상률 + 1%p -> 연봉인상률
            //나머지 9년치 입력
        }

*/#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void ran();
long int calcSalary(int rate, long int currentSalary);

struct PAY {  //연봉 정보 구조체
    long int salary;  //연봉
    int rate;		//인상률
};

struct Person {
    char name[30];
    struct PAY earns[10];
};

//===포인터, 랜덤 등 메소드 관련 items 정의//
int* rateptr = 1;
int rdNum = 0;




int upperRate[10]; // 물가인상률


int main()
{
        struct Person staff[5] = { 0, };




        srand(time(NULL));
        for (int i = 0; i < 10; i++) {
            ran();
            upperRate[i] = rdNum;

        }

        for (int i = 0; i < 10; i++) {
            printf("%d ", upperRate[i]);
        }

        //rate 주소 + i 하여 배열과 같이 설정함.

        char* name[40] = { "홍렬" , "vladimir", "путин", "союз", "dlf" };

        for (int i = 0; i < 5; i++) {
            //5명에 관해 출력

            strcpy(staff[i].name, *(name + i));


            printf("%s\n", staff[i].name);
            for (int j = 1; j <= 10; j++) {





                staff[i].earns[j].rate = upperRate[j-1] + 1;// 인상률 1~8% + 1%p(물가상승 고려) 설정
                //인상률에 따른 연봉인상률을 결정함


                staff[i].earns[j].salary = calcSalary(staff[i].earns[j].rate, staff[i].earns[j].salary);
                //각 노동자의 급료를 설정함. (calcSalary 참조)

                printf("%d년차, 연봉 : %ld만원, 상승률 : %d %\n",
                    j, staff[i].earns[j].salary, staff[i].earns[j].rate);
            }



        }
        return 0;

    }

void ran() {



        int* ptr;
        ptr = rateptr++;


        (ptr) = 1+ (rand()%8); // 인상률 1~8퍼센트


        rdNum = ptr;


        //rate 주소 + i 하여 배열과 같이 설정함.

}


long int calcSalary(int rate, long int currentSalary) {
    return ((1 + (rate / 100)) * currentSalary);
}





    /*
    for (int i = 0; i < 5; i++) {

        struct Person* worker = malloc(sizeof(struct Person));    // 구조체 포인터 선언, 메모리 할당





        strcpy(*worker->name, "홍길동");
        worker->earns[0].salary = 0;


        printf("\n이름을 입력하세요 : ");
        scanf_s("%s", *worker->name);

        printf("1");

        printf("\n협상된 연봉을 입력하세요 [1만원 단위] : ");
        scanf_s("%d", worker->earns[0].salary);




        for (int j = 1; j < 10; j++) {
            worker->earns[j].rate = *(&rate + j) + 1; //물가인상률 + 1%p -> 연봉인상률
            //나머지 9년치 입력
        }

*/


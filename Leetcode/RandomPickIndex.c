/*int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);*/
typedef struct {
    int* list;
    int size;
} Solution;

Solution* solutionCreate(int* nums, int numsSize) {
    Solution* obj = malloc(sizeof(Solution));
    obj->list = nums;
    obj->size=numsSize;
    return obj;
}

int solutionPick(Solution* obj, int target) {
    int list[50];
    int count = 0;
    int* temp = obj->list;
    int i=0;
    while(i<(obj->size)){
        if((int) *(temp+i)==target){
            list[count]=i;
            count++;
            int j=0;
            printf("Found at %i\n", i);
        }
        i++;
    }
    return list[(rand()%(count))];
}

void solutionFree(Solution* obj) {
    obj->list = NULL;
    obj->size=0;
}

/**
 * Your Solution struct will be instantiated and called as such:
 * struct Solution* obj = solutionCreate(nums, numsSize);
 * int param_1 = solutionPick(obj, target);
 * solutionFree(obj);
 */
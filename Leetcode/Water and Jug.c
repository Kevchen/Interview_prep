/*You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
*/
bool canMeasureWater(int x, int y, int z) {
    if(x+y<z){
        return false;
    }else if(z==x+y || z==x || z==y){
        return true;
    }
    return z%GCD(x,y)==0;
}

int GCD (int x, int y){
    int rem = x%y;
    if(rem==0){
        return y;
    }else{
        return GCD(y,rem);
    }
}
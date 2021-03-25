/*
 * @lc app=leetcode.cn id=1603 lang=java
 *
 * [1603] 设计停车系统
 */

// @lc code=start
class ParkingSystem {
    int[] park;
    
    public ParkingSystem(int big, int medium, int small) {
        park = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return park[carType] -- > 0;
    }
}

// class ParkingSystem {
//     int big = 0, medium = 0, small = 0;
//     public ParkingSystem(int big, int medium, int small) {
//         this.big = big;
//         this.medium = medium;
//         this.small = small;
//     }
    
//     public boolean addCar(int carType) {
//         switch (carType) {
//             case 1:
//                 if(big >= 1){
//                     big--;
//                     return true;
//                 }else{
//                     return false;
//                 }
//             case 2:
//                 if(medium >= 1){
//                     medium--;
//                     return true;
//                 }else{
//                     return false;
//                 }
//             case 3:
//                 if(small >= 1){
//                     small--;
//                     return true;
//                 }else{
//                     return false;
//                 }
        
//             default:
//                 break;
//         }
//         return false;

//     }
// }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end


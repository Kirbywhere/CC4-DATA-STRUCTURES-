
public class CountingSort {
  static int stepCount = 0;

  public static void countingSort(int[] arr) {
    int arrayLength = arr.length;
    stepCount++; // statement executed

    stepCount++; // if statement executed
    if (arrayLength == 0) {
      stepCount += 2; // statement and end curly brace executed
      return;
    }
    /** find maximum and minimum values **/
    int max = arr[0], min = arr[0];
    stepCount+= 2; // 2 statements executed

    stepCount++; // initialization for for-loop
    for (int i = 1; i < arrayLength; i++) {
      stepCount++; // conditional checked

      stepCount++; // if statement executed
      if (arr[i] > max) {
        max = arr[i];
        stepCount += 2; // +2 step count for statement executed and end curly brace
      }

      stepCount++; // if statement executed
      if (arr[i] < min) {
        min = arr[i];
        stepCount += 2; // +2 step count for statement executed and end curly brace
      }
      stepCount++; // change of state
    }
    stepCount += 2; // unmet conditional and end curly brace

    int range = max - min + 1;
    stepCount++; // statement executed

    int[] count = new int[range];
    stepCount++; // statement executed

    /** initialize the occurrence of each element in the count array **/
    stepCount++; // initialization for for-loop
    for (int i = 0; i < arrayLength; i++) {
      count[arr[i] - min]++;
      stepCount += 3; // +3 step count for conditional, body statement, and change of state
    }
    stepCount += 2; // unmet conditional and end curly brace

    /** calculate sum of indexes **/
    stepCount++; // initialization for for-loop
    for (int i = 1; i < range; i++) {
      count[i] += count[i - 1];
      stepCount += 3; // +3 step count for conditional, body statement, and change of state
    }
    stepCount += 2; // unmet conditional and end curly brace

    /** modify original array according to the sum count **/
    int j = 0;
    stepCount++; // statement executed

    stepCount++; // initialization for for-loop
    for (int i = 0; i < range; i++) {
      stepCount++; // conditional checked

      while (j < count[i]) {
        arr[j++] = i + min;
        stepCount += 2; // +2 step count for body statement and while-loop conditional checked
      }
      stepCount += 2; // unmet conditional and end curly brace
    }
    stepCount += 2; // unmet conditional and end curly brace
}

public static void printArray(int[] arr) {
  for (int i = 0; i < arr.length; i++) 
      System.out.print(arr[i] + " ");
  System.out.println("");
}
    
  public static void main(String[] args) {
    int[] trial1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000};

    int[] trial2 = {1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 978, 977, 976, 975, 974, 973, 972, 971, 970, 969, 968, 967, 966, 965, 964, 963, 962, 961, 960, 959, 958, 957, 956, 955, 954, 953, 952, 951, 950, 949, 948, 947, 946, 945, 944, 943, 942, 941, 940, 939, 938, 937, 936, 935, 934, 933, 932, 931, 930, 929, 928, 927, 926, 925, 924, 923, 922, 921, 920, 919, 918, 917, 916, 915, 914, 913, 912, 911, 910, 909, 908, 907, 906, 905, 904, 903, 902, 901, 900, 899, 898, 897, 896, 895, 894, 893, 892, 891, 890, 889, 888, 887, 886, 885, 884, 883, 882, 881, 880, 879, 878, 877, 876, 875, 874, 873, 872, 871, 870, 869, 868, 867, 866, 865, 864, 863, 862, 861, 860, 859, 858, 857, 856, 855, 854, 853, 852, 851, 850, 849, 848, 847, 846, 845, 844, 843, 842, 841, 840, 839, 838, 837, 836, 835, 834, 833, 832, 831, 830, 829, 828, 827, 826, 825, 824, 823, 822, 821, 820, 819, 818, 817, 816, 815, 814, 813, 812, 811, 810, 809, 808, 807, 806, 805, 804, 803, 802, 801, 800, 799, 798, 797, 796, 795, 794, 793, 792, 791, 790, 789, 788, 787, 786, 785, 784, 783, 782, 781, 780, 779, 778, 777, 776, 775, 774, 773, 772, 771, 770, 769, 768, 767, 766, 765, 764, 763, 762, 761, 760, 759, 758, 757, 756, 755, 754, 753, 752, 751, 750, 749, 748, 747, 746, 745, 744, 743, 742, 741, 740, 739, 738, 737, 736, 735, 734, 733, 732, 731, 730, 729, 728, 727, 726, 725, 724, 723, 722, 721, 720, 719, 718, 717, 716, 715, 714, 713, 712, 711, 710, 709, 708, 707, 706, 705, 704, 703, 702, 701, 700, 699, 698, 697, 696, 695, 694, 693, 692, 691, 690, 689, 688, 687, 686, 685, 684, 683, 682, 681, 680, 679, 678, 677, 676, 675, 674, 673, 672, 671, 670, 669, 668, 667, 666, 665, 664, 663, 662, 661, 660, 659, 658, 657, 656, 655, 654, 653, 652, 651, 650, 649, 648, 647, 646, 645, 644, 643, 642, 641, 640, 639, 638, 637, 636, 635, 634, 633, 632, 631, 630, 629, 628, 627, 626, 625, 624, 623, 622, 621, 620, 619, 618, 617, 616, 615, 614, 613, 612, 611, 610, 609, 608, 607, 606, 605, 604, 603, 602, 601, 600, 599, 598, 597, 596, 595, 594, 593, 592, 591, 590, 589, 588, 587, 586, 585, 584, 583, 582, 581, 580, 579, 578, 577, 576, 575, 574, 573, 572, 571, 570, 569, 568, 567, 566, 565, 564, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 504, 503, 502, 501, 500, 499, 498, 497, 496, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 477, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 460, 459, 458, 457, 456, 455, 454, 453, 452, 451, 450, 449, 448, 447, 446, 445, 444, 443, 442, 441, 440, 439, 438, 437, 436, 435, 434, 433, 432, 431, 430, 429, 428, 427, 426, 425, 424, 423, 422, 421, 420, 419, 418, 417, 416, 415, 414, 413, 412, 411, 410, 409, 408, 407, 406, 405, 404, 403, 402, 401, 400, 399, 398, 397, 396, 395, 394, 393, 392, 391, 390, 389, 388, 387, 386, 385, 384, 383, 382, 381, 380, 379, 378, 377, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 329, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 312, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 255, 254, 253, 252, 251, 250, 249, 248, 247, 246, 245, 244, 243, 242, 241, 240, 239, 238, 237, 236, 235, 234, 233, 232, 231, 230, 229, 228, 227, 226, 225, 224, 223, 222, 221, 220, 219, 218, 217, 216, 215, 214, 213, 212, 211, 210, 209, 208, 207, 206, 205, 204, 203, 202, 201, 200, 199, 198, 197, 196, 195, 194, 193, 192, 191, 190, 189, 188, 187, 186, 185, 184, 183, 182, 181, 180, 179, 178, 177, 176, 175, 174, 173, 172, 171, 170, 169, 168, 167, 166, 165, 164, 163, 162, 161, 160, 159, 158, 157, 156, 155, 154, 153, 152, 151, 150, 149, 148, 147, 146, 145, 144, 143, 142, 141, 140, 139, 138, 137, 136, 135, 134, 133, 132, 131, 130, 129, 128, 127, 126, 125, 124, 123, 122, 121, 120, 119, 118, 117, 116, 115, 114, 113, 112, 111, 110, 109, 108, 107, 106, 105, 104, 103, 102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    int[] trial3 = {881, 349, 427, 825, 262, 830, 209, 547, 192, 429, 743, 984, 414, 749, 163, 823, 384, 101, 133, 632, 651, 525, 370, 506, 199, 473, 835, 449, 354, 793, 299, 305, 459, 653, 493, 849, 41, 852, 873, 979, 318, 334, 777, 981, 418, 576, 504, 285, 139, 340, 621, 287, 753, 40, 620, 113, 745, 295, 288, 275, 164, 770, 837, 467, 799, 495, 741, 240, 858, 588, 282, 102, 886, 350, 410, 829, 876, 207, 868, 969, 757, 538, 828, 563, 399, 874, 236, 492, 635, 592, 897, 400, 237, 614, 303, 775, 930, 561, 371, 617, 112, 304, 805, 460, 417, 734, 21, 642, 940, 242, 273, 564, 520, 985, 667, 33, 558, 439, 790, 856, 565, 124, 597, 748, 481, 932, 451, 16, 224, 130, 249, 871, 11, 649, 783, 386, 341, 415, 110, 732, 348, 827, 648, 652, 736, 259, 379, 619, 234, 364, 147, 639, 586, 461, 521, 840, 374, 678, 26, 847, 151, 605, 953, 853, 171, 135, 174, 149, 65, 986, 185, 684, 380, 567, 359, 591, 738, 486, 712, 25, 344, 815, 13, 296, 579, 894, 903, 23, 27, 750, 626, 89, 474, 96, 983, 718, 123, 580, 176, 327, 791, 280, 396, 834, 367, 522, 469, 122, 465, 968, 292, 795, 780, 356, 551, 533, 601, 264, 645, 976, 283, 433, 503, 893, 613, 812, 813, 758, 796, 472, 38, 221, 93, 936, 696, 54, 165, 36, 917, 432, 725, 779, 807, 671, 99, 534, 944, 239, 854, 798, 337, 879, 819, 505, 957, 8, 544, 896, 499, 955, 747, 332, 457, 501, 10, 666, 220, 339, 313, 187, 776, 276, 431, 950, 136, 319, 694, 877, 781, 453, 357, 562, 816, 421, 542, 973, 1, 500, 442, 676, 923, 395, 454, 434, 787, 967, 594, 999, 599, 269, 181, 680, 104, 754, 826, 48, 786, 701, 205, 73, 353, 808, 641, 726, 730, 664, 284, 919, 577, 566, 272, 191, 821, 462, 184, 883, 97, 914, 138, 345, 375, 132, 898, 670, 300, 70, 197, 422, 939, 145, 76, 810, 324, 933, 992, 204, 361, 681, 921, 717, 744, 281, 169, 261, 28, 971, 42, 756, 157, 762, 202, 637, 857, 519, 342, 975, 630, 789, 59, 842, 480, 229, 464, 425, 647, 710, 803, 351, 55, 214, 336, 602, 168, 329, 900, 965, 180, 764, 824, 683, 120, 194, 643, 407, 32, 516, 210, 7, 46, 109, 121, 612, 593, 915, 977, 833, 624, 572, 497, 270, 870, 557, 116, 75, 716, 510, 335, 622, 890, 587, 412, 80, 266, 929, 989, 252, 61, 700, 20, 385, 910, 628, 235, 773, 843, 693, 634, 245, 108, 225, 79, 952, 568, 17, 323, 250, 483, 515, 661, 203, 150, 943, 490, 998, 540, 195, 887, 387, 208, 990, 307, 604, 161, 219, 372, 707, 814, 800, 627, 640, 343, 662, 152, 215, 885, 927, 293, 817, 806, 545, 362, 802, 129, 125, 213, 771, 636, 682, 391, 19, 243, 722, 489, 2, 146, 148, 512, 218, 409, 851, 549, 333, 277, 964, 848, 484, 698, 947, 321, 100, 401, 31, 238, 105, 514, 363, 158, 941, 491, 62, 406, 578, 173, 310, 81, 263, 233, 347, 687, 988, 378, 246, 488, 419, 405, 901, 610, 47, 859, 785, 742, 117, 794, 278, 507, 253, 958, 729, 555, 841, 804, 355, 45, 322, 995, 836, 230, 177, 131, 226, 182, 912, 107, 509, 114, 458, 603, 141, 752, 865, 352, 211, 463, 91, 966, 650, 478, 767, 228, 546, 616, 143, 436, 907, 217, 57, 692, 709, 945, 916, 144, 801, 430, 878, 663, 468, 746, 782, 768, 443, 90, 196, 193, 761, 83, 441, 50, 772, 607, 60, 769, 697, 376, 860, 255, 424, 618, 845, 498, 548, 553, 256, 997, 24, 44, 326, 320, 838, 244, 609, 909, 655, 884, 389, 496, 186, 274, 920, 792, 541, 513, 740, 448, 390, 724, 22, 963, 301, 585, 260, 383, 809, 869, 539, 960, 444, 373, 733, 366, 951, 85, 937, 685, 34, 314, 657, 938, 222, 713, 644, 908, 291, 582, 658, 170, 962, 402, 880, 674, 134, 654, 315, 43, 309, 925, 198, 254, 530, 615, 142, 137, 974, 423, 103, 942, 889, 589, 760, 611, 948, 675, 84, 306, 49, 98, 317, 905, 715, 502, 316, 6, 172, 298, 403, 991, 926, 265, 552, 820, 479, 623, 438, 189, 66, 470, 982, 646, 875, 695, 629, 714, 831, 29, 78, 723, 536, 377, 532, 179, 452, 178, 39, 428, 394, 902, 290, 118, 911, 704, 524, 571, 556, 1000, 906, 82, 535, 92, 200, 575, 416, 289, 397, 895, 994, 88, 188, 445, 212, 708, 159, 477, 554, 190, 466, 573, 398, 931, 360, 494, 308, 766, 751, 404, 426, 440, 673, 570, 128, 338, 529, 156, 954, 294, 175, 517, 411, 140, 297, 68, 706, 904, 668, 413, 456, 127, 864, 471, 37, 526, 420, 583, 778, 74, 160, 527, 699, 891, 728, 972, 71, 550, 487, 51, 286, 913, 866, 216, 162, 408, 996, 711, 523, 476, 677, 918, 703, 850, 106, 934, 508, 863, 119, 183, 719, 633, 14, 735, 3, 691, 638, 928, 669, 935, 656, 584, 77, 231, 206, 924, 5, 346, 382, 482, 446, 35, 596, 600, 381, 56, 12, 358, 765, 312, 368, 247, 606, 365, 53, 784, 9, 166, 755, 302, 267, 690, 759, 167, 268, 788, 328, 64, 946, 153, 325, 447, 126, 154, 15, 731, 248, 899, 980, 52, 672, 832, 922, 18, 86, 528, 485, 956, 861, 846, 58, 797, 721, 330, 331, 241, 818, 475, 688, 537, 705, 574, 959, 392, 388, 69, 888, 569, 450, 581, 227, 518, 257, 251, 987, 855, 679, 455, 882, 258, 737, 970, 727, 689, 155, 437, 598, 872, 543, 949, 595, 660, 625, 435, 993, 844, 279, 311, 631, 659, 822, 67, 95, 393, 271, 608, 223, 201, 560, 665, 111, 72, 720, 531, 811, 978, 702, 369, 232, 63, 961, 30, 559, 4, 763, 511, 892, 774, 686, 94, 115, 839, 862, 739, 87, 867, 590};
    
    System.out.println("======================================================");
    System.out.println("COUNTING SORT");
    System.out.println("==============UNSORTED ARRAY TRIAL 1==================");
    printArray(trial1);
    System.out.println("==============UNSORTED ARRAY TRIAL 2==================");
    printArray(trial2);
    System.out.println("==============UNSORTED ARRAY TRIAL 3==================");
    printArray(trial3);
    System.out.println("======================================================");

    // Function call
    stepCount = 1;
    countingSort(trial1);
    stepCount++;
    int TFC1 = stepCount;
    System.out.println("Total step count for counting sort of trial 1: " + stepCount);

    stepCount = 1;
    countingSort(trial2);
    stepCount++;
    int TFC2 = stepCount;
    System.out.println("Total step count for counting sort of trial 2: " + stepCount);

    stepCount = 1;
    countingSort(trial3);
    stepCount++;
    int TFC3 = stepCount;
    System.out.println("Total step count for counting sort of trial 3: " + stepCount);

    System.out.println("======================================================");

    System.out.println("Average step count for the three trials: " + Math.round((TFC1 + TFC2 + TFC3) / 3.0));
    System.out.println("======================================================");

    System.out.println("SORTED ARRAY 1");
    printArray(trial1);
    System.out.println("SORTED ARRAY 2");
    printArray(trial2);
    System.out.println("SORTED ARRAY 3");
    printArray(trial3);
      
  }
}

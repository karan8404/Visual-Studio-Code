import java.util.Arrays;

public class problem2491 {
    //divide the team with skills.

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int front=0,end=skill.length-1;
        int sum=skill[front]+skill[end];
        long res=0;
        while(front<end){
            if(skill[front]+skill[end]!=sum)
                return -1;
            
            res+=skill[front]*skill[end];
            front++;end--;
        }

        return res;
    }
}

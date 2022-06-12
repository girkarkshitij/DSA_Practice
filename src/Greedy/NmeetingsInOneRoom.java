class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<List<Integer>> meetings = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            ArrayList<Integer> meet = new ArrayList<>();
            meet.add(start[i]);
            meet.add(end[i]);
            meetings.add(meet);
        }
        
        Collections.sort(meetings, new Comparator<>(){
            public int compare(List o1, List o2){
                return (int)o1.get(1) - (int)o2.get(1);
            }
        });
        
        int ans = 1;
        int i = 1, lastEnd = meetings.get(0).get(1);
        
        while(i<n){
            if(meetings.get(i).get(0)> lastEnd){
                lastEnd = meetings.get(i).get(1);
                ans++;
            }
            i++;
        }
        
        return ans;
    }
}

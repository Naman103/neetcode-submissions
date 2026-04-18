class Twitter {
    Map<Integer, Set<Integer>> followingMap;
    Map<Integer, List<Integer>> userNewsFeedMap;
    int tweetEntryTime = 0;
    Map<Integer, Integer> tweetEntryTimeMap;
    public Twitter() {
        followingMap = new HashMap<>();
        userNewsFeedMap = new HashMap<>();
        tweetEntryTimeMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetEntryTime++;
        tweetEntryTimeMap.put(tweetId, tweetEntryTime);
        if(userNewsFeedMap.containsKey(userId)) {
            userNewsFeedMap.get(userId).add(tweetId);
        } else {
            List<Integer> feedList = new ArrayList<>();
            feedList.add(tweetId);
            userNewsFeedMap.put(userId, feedList);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> newsFeedList = new PriorityQueue<>((a, b) -> tweetEntryTimeMap.get(b) - tweetEntryTimeMap.get(a));
        Set<Integer> feedIdList = new HashSet<>();
        
        if(userNewsFeedMap.containsKey(userId)) {
            for(int newsFeedId : userNewsFeedMap.get(userId)) {
                if(!feedIdList.contains(newsFeedId))
                    newsFeedList.offer(newsFeedId);
                feedIdList.add(newsFeedId);
            }
        }
        
        if(followingMap.containsKey(userId)) {
            Set<Integer> followingUserList = followingMap.get(userId);
            for(int followingUserId : followingUserList) {
                if(userNewsFeedMap.containsKey(followingUserId)) {
                    for(int newsFeedId : userNewsFeedMap.get(followingUserId)) {
                        if(!feedIdList.contains(newsFeedId))
                            newsFeedList.offer(newsFeedId);
                        
                        feedIdList.add(newsFeedId);
                    }
                }
            }  
        }

        List<Integer> latestNewsFeed = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Integer newsFeedId = newsFeedList.poll();
            if(newsFeedId != null)
                latestNewsFeed.add(newsFeedId);
        }

        return latestNewsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> followeeList = new HashSet<>();
            followeeList.add(followeeId);
            followingMap.put(followerId, followeeList);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }

        for(Map.Entry<Integer, Set<Integer>> entry : followingMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for(int v : entry.getValue()) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
    }
}

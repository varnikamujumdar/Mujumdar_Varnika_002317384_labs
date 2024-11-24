/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author Varnika Mujumdar
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    
//Q.1 Find Average number of likes per comment.
    
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        System.out.println("1.Average number of likes per comments: " + likeNumber / commentNumber);
         System.out.println();
        }
    
    //Q.2 Post With most likes per comment:
    
    public void getMaxLikeCommentPost(){
        DataStore data = DataStore.getInstance();
        Comment commentWithmMaxLikes = null ;
        for (Comment c : data.getComments().values()){
            if( commentWithmMaxLikes == null){
                 commentWithmMaxLikes = c;
            }
            if (c.getLikes()> commentWithmMaxLikes.getLikes()){
                 commentWithmMaxLikes = c;
            }
        }
        int postId= commentWithmMaxLikes.getPostId();
        System.out.println( "2.Post With most likes per comment:  "+data.getPosts().get(postId).getPostId());
         System.out.println();
    }
    
    //Q.3 Post With most comment: 
    
    public void getPostWithMostComments(){
        DataStore data = DataStore.getInstance();
        Post postWithMostComments = null ;
        for (Post p : data.getPosts().values()){
            if( postWithMostComments == null){
                 postWithMostComments = p;
            }
            if(p.getComments().size()> postWithMostComments.getComments().size()){
                   postWithMostComments=p;
            }
            }
        System.out.println( "3.Post With most comment:  " +    postWithMostComments.getPostId());
         System.out.println();
        }
    
    
    //Q.4
    public void getPassiveUsers(){
        DataStore data = DataStore.getInstance();
        
        HashMap<Integer, Integer> postNumbers = new HashMap<Integer,Integer>();
        for(Post p: data.getPosts().values()){
            int userId = p.getUserId();
            if(postNumbers.containsKey(userId)){
                postNumbers.put(userId,postNumbers.get(userId)+1);
            }else{
                postNumbers.put(userId,1);
            }
        }
        ArrayList<User> users = new ArrayList(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(postNumbers));
        System.out.println("4. The following users have the last posts:  ");
        for (int i = 0; i<5;i++){
            System.out.println(users.get(i)+" ,- Post Count:"+ postNumbers.get(users.get(i).getId()));
             System.out.println();
        }
    }
     
    //Q.5 Users have the last posts 

public void getPassiveCommentUsers(){
        DataStore data = DataStore.getInstance();
        HashMap<Integer, Integer> commentNumbers = new HashMap<Integer,Integer>();
        for(Comment c: data.getComments().values()){
            int userId = c.getUserId();
            if(commentNumbers.containsKey(userId)){
                commentNumbers.put(userId,commentNumbers.get(userId)+1);
            }else{
               commentNumbers.put(userId,1);
            }
        }
        ArrayList<User> users = new ArrayList(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(commentNumbers));
        System.out.println("5. The following users have the least Comments:  ");
         System.out.println();
        for (int i = 0; i<5;i++){
            System.out.println(users.get(i)+" ,- Comment Count:"+ commentNumbers.get(users.get(i).getId()));
            
        }
    }  

//Q.5 Top 5 inactive users overall

 public void getPassiveAndActiveOverallUsers() {
    DataStore data = DataStore.getInstance();
    HashMap<Integer, Integer> overallNumbers = new HashMap<>();

    // Populate the overallNumbers map
    for (Comment c : data.getComments().values()) {
        int userId = c.getUserId();
        overallNumbers.put(userId, overallNumbers.getOrDefault(userId, 0) + 1 + c.getLikes());
    }

    for (Post p : data.getPosts().values()) {
        int userId = p.getUserId();
        overallNumbers.put(userId, overallNumbers.getOrDefault(userId, 0) + 1);
    }

    // Get users and sort them
    ArrayList<User> users = new ArrayList<>(data.getUsers().values());
    Collections.sort(users, new UserMapComparator(overallNumbers));
    

    // Display top 5 passive users
     System.out.println();
    System.out.println("6. The following users have overall been passive: ");
     System.out.println();
    for (int i = 0; i < 5 && i < users.size(); i++) {
        System.out.println(users.get(i) + ", - Overall Count: " + overallNumbers.getOrDefault(users.get(i).getId(), 0));
       
    }

    // Display top 5 active users
     System.out.println();
    System.out.println("7. The following users have overall been active: ");
    for (int i = users.size() - 1; i >= users.size() - 5 && i >= 0; i--) {
        System.out.println(users.get(i) + ", - Overall Count: " + overallNumbers.getOrDefault(users.get(i).getId(), 0));
         
    }
}

     
 }
    
 


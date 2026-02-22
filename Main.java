package prolab;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static ArrayList<User> kullanicilar=new ArrayList<>();
    public static User seciliuser = null;
    public static void main(String[] args) {

        int count1=0;
        int count2=0;
        int count3=0;

        //JSON dosyasindan kullanici objelerini alma islemi
        Gson gson = new Gson();

        //Whatsapp grubuna atılan data için

        /*myHashMap<String,User> hashMap = new myHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Anıl\\IdeaProjects\\Prolab-3\\twitter_data.json"));
             JsonReader reader = new JsonReader(br)) {

            reader.beginArray(); // JSON dizisi başlangıcı

            while (reader.hasNext()) {
                User user = gson.fromJson(reader, User.class);
                //System.out.println(user.getUsername());
                hashMap.put(user.getUsername(),user);
                System.out.print(user.getUsername()+"       ");
                System.out.println(hashMap.get(user.getUsername()));
                count1++;
            }

            reader.endArray(); // JSON dizisi sonu

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Burağın datası için ama Burak'ın kodunundan bakarak yazdım

        myHashMap<String, User> hashMap = new myHashMap<>();
        ArrayList<String> keyset = new ArrayList<>();
        GraphModel fgraph = new GraphModel<>(true);

        try {
            JsonArray jArray = gson.fromJson(new FileReader("fake_users_data2.json"), JsonArray.class);

            for (JsonElement jElement : jArray) {
                JsonObject user = jElement.getAsJsonObject();
                JsonObject userInfo = user.getAsJsonObject("kullanici_bilgileri");
                String username = userInfo.get("kullanici_adi").getAsString();
                String nameSurname = userInfo.get("ad_soyad").getAsString();
                int followersCount = userInfo.get("takipci_sayisi").getAsInt();
                int followingCount = userInfo.get("takip_edilen_sayisi").getAsInt();
                String language = userInfo.get("dil").getAsString();
                String region  = userInfo.get("bolge").getAsString();

                UserInfo userInfo1 = new UserInfo(username,nameSurname,followersCount,followingCount,language,region);
                keyset.add(username);


                JsonArray tweetsContents = user.getAsJsonArray("tweet_icerikleri");
                ArrayList AtweetContents = new ArrayList<>();
                for (int i = 0; i < tweetsContents.size(); i++){
                    JsonObject Tweet = tweetsContents.get(i).getAsJsonObject();
                    long id = Tweet.get("tweet_id").getAsInt();
                    String content = Tweet.get("icerik").getAsString();
                    String hashtag = Tweet.get("hashtag").getAsString();
                    Tweets tweet = new Tweets(id,content,hashtag);
                    AtweetContents.add(tweet);
                }



                JsonObject FollowersandFollowing = user.getAsJsonObject("takip_edilen_ve_takipciler");
                JsonArray followers = FollowersandFollowing.getAsJsonArray("takip_edilenler");
                ArrayList Afollowers = new ArrayList<>();
                for (int j = 0;j < followers.size(); j++){
                    String follower = followers.get(j).getAsString();
                    Afollowers.add(follower);
                }

                JsonArray following = FollowersandFollowing.getAsJsonArray("takipciler");
                ArrayList Afollowing = new ArrayList<>();
                for (int k = 0; k < following.size(); k++){
                    String followingPerson = following.get(k).getAsString();
                    Afollowing.add(followingPerson);
                }

                FollowersAndFollowing followersandFollowing = new FollowersAndFollowing(Afollowing,Afollowers);

                User newUser = new User(userInfo1,AtweetContents,followersandFollowing);
                kullanicilar.add(newUser);
                //newUser.printObject();
                hashMap.put(newUser.getUserInfo().getUsername(),newUser);

                GraphVertex vertex = new GraphVertex<>(hashMap.get(newUser.getUserInfo().getUsername()));
                fgraph.addVertex(vertex);
                //String key = newUser.getUserInfo().getUsername();
                //System.out.print(key + "       ");
                //System.out.println(hashMap.get(key));


                //System.out.println(user);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        //System.out.println("hashMap Size: "+hashMap.size());
        //System.out.println(count1);
        //System.out.println(count2);
        //System.out.println(count3);



        int count=0;

        /*for(int i=0;i< hashMap.size();i++){
            //hashMap.get(keyset.get(i)).getFollowing();
            //System.out.println(hashMap.get(keyset.get(i)).getUserInfo().getUsername());
            //System.out.println(hashMap.get(keyset.get(i)).getFollowing());
            //System.out.println(hashMap.get(keyset.get(i)));
            User user = hashMap.get(keyset.get(i));
            GraphVertex<User> userNode = new GraphVertex(user);

            for(int j=0;j < user.getFollowerRelationship().getFollowing().size();j++){
                User user2 = hashMap.get(user.getFollowerRelationship().getFollowing().get(j));
                GraphVertex<User> followingNode = new GraphVertex(user2);
                fGraph.addVertex(userNode);
                fGraph.addVertex(followingNode);
                fGraph.addEdge(userNode,followingNode);
            }



            //System.out.println(userNode.getData().getFollowing().get(i));

            //System.out.println(userNode.getData().getFollowing());
        }*/
        //System.out.println(count);

        for (int i=0; i<fgraph.getVertices().size();i++){
            GraphVertex vertex = (GraphVertex) fgraph.getVertices().get(i);

            User user = (User) vertex.getData();
            ArrayList<String> followed = user.getFollowerRelationship().getFollowing();

            for (int j = 0; j < followed.size(); j++) {
                String username = (String) followed.get(j);
                ArrayList<String> followed2 = user.getFollowerRelationship().getFollowing();
                GraphVertex followedUser = fgraph.getVertexbyValue(username);

                fgraph.addEdge(vertex, followedUser);
                count++;
                //-----------------------------------------------
                if(followed2.get(j).contains(user.getUserInfo().getUsername())){
                    fgraph.addEdge(followedUser,vertex);
                }
            }

        }
        //fgraph.print();
        //System.out.println(count);
        //Kullanıcının tweetlerindeki kelimeleri sayarak ilgi alanı bulma
        int count4 = 0;

        ArrayList<String> fieldOfInterests = new ArrayList<>();
        myHashMap<String,Integer> fieldOfInterestsCounter = new myHashMap<>();
        for (int i = 0; i < hashMap.size(); i++){
            User user = hashMap.get(keyset.get(i));
            ArrayList<String> tweetsContens = new ArrayList<>();
            //System.out.println(i+1+". kullanıcının tweetleri");
            //System.out.println("getTweetContents.size: "+user.getTweetsContents().size());
            for (int j = 0; j < user.getTweetsContents().size(); j++) {
                tweetsContens.add(user.getTweetsContents().get(j).getContent());
                StringTokenizer stringTokenizer = new StringTokenizer(tweetsContens.get(j), " ");
                //System.out.println(j+1+". tweeti");
                while (stringTokenizer.hasMoreTokens()) {
                    String AInterest = stringTokenizer.nextToken();
                    //System.out.println(AInterest);
                    if (fieldOfInterests.contains(AInterest)) {
                        continue;
                    } else {
                        fieldOfInterests.add(AInterest);
                    }
                    count4++;
                }
                //System.out.println();
            }
        }
        //System.out.println("count4: "+count4);
        //System.out.println("fieldOfInterests"+fieldOfInterests);
        //System.out.println("Size of fieldOfInterests: "+fieldOfInterests.size());
//-------------------------------------------------------------------------------------
        //Kullanıcılar
        System.out.println("Kullancılar:");
        int count5=0;
        for(int i=0;i< keyset.size();i++){
            count5++;
            System.out.println(keyset.get(i));
        }
        //System.out.println(keyset.size());
        //System.out.println(count5);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                firstFrame f = new firstFrame();
                f.setVisible(true);

            }
        });



    }
}


/*GraphVertex key = fgraph.getVertexbyValue(user);
                User userWeLook = (User) key.getData();
                if(userWeLook.getFollowerRelationship().getFollowing().get(j).equals(user.getUserInfo().getUsername())){
                    fgraph.addEdge(followedUser,vertex);
                }*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String,User> userMap;

    public Authentication()
    {
        userMap = new HashMap<>();
    }

    public boolean register(String username, String password) {
        if (userMap.containsKey(username)) {
            System.out.println("username already exists");
            return false;
        }

        String hashedPassword = hashPassword(password);
        userMap.put(username,new User(username,hashedPassword));
        System.out.println("user registered succesfully");
        return true;
        //userMap.put(username, new User(username, password));
        //System.out.println("User registered succesfully");
        //return true;
    }

        public User login(String username, String password)
        {
            User user = userMap.get(username);
            if(user!=null && user.getPassword().equals(hashPassword(password)))
            {
                System.out.println("Login succesful. Welcome " + username + "!");
                return user;
            }
            System.out.println("Invalid username or password");
            return null;
        }

        private String hashPassword(String password)
        {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] encodedHash = digest.digest(password.getBytes());
                return bytesToHex(encodedHash);

            }catch (NoSuchAlgorithmException e){throw new RuntimeException("Error hashing password", e);}
        }

        private String bytesToHex(byte[] hash)
        {
            StringBuilder hexString = new StringBuilder();
            for(byte b: hash)
            {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }


        public void viewAllUsers()
        {
            if(userMap.isEmpty())
            {
                System.out.println("no users");
            }
            else {
                System.out.println("registered users: ");
                for(Map.Entry<String, User> entry : userMap.entrySet())
                {
                    String username = entry.getKey();
                    String hashedPassword = entry.getValue().getPassword();
                    System.out.println(" username: " + username + " - password: " + hashedPassword);
                }
            }
        }




}

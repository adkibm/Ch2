# Ch2
# Cheherlock
App for online verfication of Tenants and Maids.

Demo Video Link : https://drive.google.com/file/d/0BxoUdajWBwEEZk1FZDdYTjZTY1E/view?usp=sharing

The most important job of police verification of tenants and house maids is often ignored. 
This app can simplify that process using IBM Watson Alchemy Vision API. This is just a small POC of the actual app that is to be built.

Working:
- Install App.
- Create an account.
- Open app and upload a new Tenant/Maid profile with image of the concerned person against a clear background.
- Upload the profile.
- When profile is visible in My Profiles Tab click on verify and Image of that person Image will be matched in online database.
- If there is a different name found in the Images where the face match returns a higher confidence value , it will show a failed result.
- As per current Alchemy API the Image database is trained only for Celebrities for Facial Recognition. So it only shows a verification of
3 pre added records.

Further , idea can be expanded to a complete online database face search where a list of probable face matches will be returned and in case 
it found that same person has been present somewhere else with same name , local authorities can be alerted.


/*
Julie Daly
205 Final Project-Computer Logic
*/

import java.util.*;

public class Computer1{
   //Creating necessary objects and assigning the color RED to the computer
   Deck card = new Deck();
   Color color = Color.RED;
   Pawn pieceOne = new Pawn(color);
   Pawn pieceTwo = new Pawn(color);
   Pawn pieceThree = new Pawn(color);
   Pawn pieceFour = new Pawn(color);
   Board aSpace = new Board();
   //Holds START space for the color RED
   RoundSpace starts = aSpace.getStart(color);
   //Creates arraylist of all pawns
   ArrayList<Pawn> allPawns = new ArrayList<Pawn>();
   
 
   
   public Computer1()throws BoardException{
   //Adds pawns to arraylist
   allPawns.add(pieceOne);
   allPawns.add(pieceTwo);
   allPawns.add(pieceThree);
   allPawns.add(pieceFour);
   starts.placePawn(pieceOne);
   starts.placePawn(pieceTwo);
   starts.placePawn(pieceThree);
   starts.placePawn(pieceFour);
   moves();
   
   }
   //move method based on card value
   public void moves()throws BoardException{
   //Draws card
   int cards = card.draw();
      //goes through all cards *card 7,10,13 are still being treated as normal cards*
      if (cards==1){
         if (starts.occupied() == true){
            //Uses loop to go through array to find the pawn occupying home
            for (int i=0; i<allPawns.size();i++){
               if (starts.occupiedBy(allPawns.get(i))==true){
               //Move one space out of home, home is noted to have index 4 then exits
               SquareSpace moveTo = aSpace.getSpace(5);
               aSpace.movePawn(allPawns.get(i), moveTo);
               System.exit(0);
               
               }}}
         else {
           //Or passes card number to chooseMove method
           chooseMove(cards);
           
           }}
           
      else if (cards ==2){
         if (starts.occupied() == true){
            //Same as card==1 case 
           for (int i=0; i<allPawns.size();i++){
               if (starts.occupiedBy(allPawns.get(i))==true){
               //index 6 instead of 5
               SquareSpace moveTo = aSpace.getSpace(6);
               aSpace.movePawn(allPawns.get(i), moveTo);
               System.exit(0);
               }}}
         else {
           chooseMove(cards);
           
            }}
      
      else if (cards==3){
         //checks if home is not fully occupied then passes to method
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
          else{
            //can't move and exits
            System.exit(0);
            }
           }
           
      else if (cards==4){
         //same as card==3 but passes -4 to move backwards
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(-4);
           }
           else{
            System.exit(0);
            }}
           
      else if (cards==5){ 
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
            
          
           
      else if (cards==7){
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
            
      else if (cards==8){
         //same as above
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
            
      else if (cards==10){
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
            
      else if (cards==11){
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
            
       else if (cards==12){
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}     
           
       else if (cards==13){
         //same as above
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == false){
            chooseMove(cards);
           }
           else{
            System.exit(0);
            }}
      else{
      //prints invalid if card not read properly
      System.out.print("Invalid");
      }
   
   
   
   }
   public void chooseMove(int card)throws BoardException{
   //call on method that pulls index of pawn and stores it in int called pawnIndex
    boolean flag = true; 
    
    while(flag = true){
      
      //Uses loop to go through all pawns
      for(int i = 0; i < allPawns.size(); i++){
      
         //gets space that pawn in occupying
         Space pawn = allPawns.get(i).getSpace();
         
         //gets index of that space                    
         int pawnIndex = ((SquareSpace)pawn).getIndex();
         //adds index to the total card number
         int total = pawnIndex + card;
         //gets space whose index is total
         SquareSpace moveTo = aSpace.getSpace(total);
       //Checks if by a slide, moves to that space and changes flag to false
         if ((total % 15 == 9)||(total % 15 == 1)){
            if (pawn.getColor()!=color){
               Pawn chosen = (Pawn)allPawns.get(i);
               aSpace.movePawn(chosen, moveTo);
               flag=false;}
            else{
               break;
               }
      
      }
    //Check if by safety, moves to that space and flips flag
         else if (total%15 == 2){
            if (pawn.getColor()==color){
               Pawn chosen = (Pawn)allPawns.get(i);
               aSpace.movePawn(chosen, moveTo);
               flag=false;}
            else{
               break;}
      
      }
   //Checks in the space is occupied
         
         else if (moveTo.occupied() == true){
            //gets pawn occupying that space
            Pawn otherPawn = moveTo.getOccupant();
            //if same color breaks out of for loop
            if(otherPawn.getColor() == color){
            break;}
            //if other color moves to that space and flips flag
            if(otherPawn.getColor() != color){
               Pawn chosen = (Pawn)allPawns.get(i);
               aSpace.movePawn(chosen, moveTo);
               flag=false;
   } }
      //breaks out of for loop
      else{
         break;
         }}
         //if none above are true with randomly pick a pawn from array 
         Random rand = new Random();
         int n = rand.nextInt(4); 
         Pawn chosen = allPawns.get(n);
         //gets space
         Space pawn = allPawns.get(n).getSpace();
         //gets index
         int pawnIndex = ((SquareSpace)pawn).getIndex();
         int total = pawnIndex + card;
         //moves that pawn to that space and  flips flag
         SquareSpace moveTo = aSpace.getSpace(total);
         aSpace.movePawn(chosen, moveTo);
         flag =false;
}}}

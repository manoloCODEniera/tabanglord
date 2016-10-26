import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class Game extends Frame {
	
	// declarations and definitions of instance variables
	
	private final Label lblYourChoice =  new Label("Your Choice: ");
	private final Label lblpScore =  new Label("Player's Score");
	private final Label lblcScore =  new Label("Computer's Score");
	//private final Label lblRPSLS =  new Label("RockPaperScissorsLizardSpock!");
	private TextField txtPS = new TextField();
	private TextField txtCS = new TextField();
	/*
	 
	  ***** DO NOT USE! TOOK ME FOREVER TO DEBUG I AM STUPID*****
	 
	  private final int pScore = 0;
	  private final int cScore = 0;
	  
	  
	 */
	private int pScore;
	private int cScore;
	////
	private Button btnRun = new Button("RockPaperScissorsLizardSpock!");
	////
	private final  CheckboxGroup hand = new CheckboxGroup();
	
	private Checkbox rock = new Checkbox("Rock", hand, true);
	private Checkbox paper = new Checkbox("Paper", hand, false);
	private Checkbox scissors = new Checkbox("Scissors", hand, false);
	private Checkbox lizard = new Checkbox("Lizard", hand, false);
	private Checkbox spock = new Checkbox("Spock", hand, false);
	
	private TextArea txtResult = new TextArea("Results: ", 5, 45);
	
	Dialog sticky;
	
	public Game() {
		
		add(lblYourChoice);
		add(rock);
		add(paper);
		add(scissors);
		add(lizard);
		add(spock);
		add(txtResult);
		add(btnRun);
		add(lblpScore);
		add(txtPS);
		add(lblcScore);		
		add(txtCS);
		
		
		
		setSize(500, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		
		// action listeners
		
		btnRun.addActionListener(new ActionListener(){
			

			private String playerChoice;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(hand.getSelectedCheckbox().getName());
				
				Random rnd = new Random();
				String compChoice = "";
				int computerSelection = rnd.nextInt(5);
				switch(computerSelection){
					case 0: {
						compChoice = "Spock";
						break;
					}case 1: {
						compChoice = "Rock";
						break;
					}case 2: {
						compChoice = "Paper";
						break;
					}case 3: {
						compChoice = "Scissors";
						break;
					}case 4: {
						compChoice = "Lizard";
						break;
					}
				
				}
				playerChoice = hand.getSelectedCheckbox().getName();
				txtResult.setText(compute(playerChoice,compChoice));
				txtCS.setText(Integer.toString(cScore));
				txtPS.setText(Integer.toString(pScore));
				
				
				if(pScore ==5 || cScore == 5){
					
					gameOver();
					pScore = 0;
					cScore =0;
					txtPS.setText(Integer.toString(cScore));
					txtCS.setText(Integer.toString(pScore));
				}
			}
			
		}
		);
		
		// window listener
		
		addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// do nothing
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
	
				System.exit(0);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// do nothing
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// do nothing
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// do nothing
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// do nothing
				
			}
			
			
		});
		
		
		
		// *** REMOVED ***//
		
		
		
	}
	
	// this method determines who wins, and then updates scores.
	
	private String compute(String playerChoice, String compChoice) {
		String result = "";
		
		
		//ROCK
		if(playerChoice.equals("checkbox0")){
			playerChoice = "Rock";
			if(compChoice.equals("Paper") || compChoice.equals("Spock")){
				
				
				result = compChoice + " beats " + playerChoice;
				cScore++;
				
			}else if(playerChoice.equals(compChoice)){
				result = "It's a tie for this round!";
			}else{
				result = playerChoice +" beats "+compChoice;
				pScore++;
			}
		//PAPER
		}else if(playerChoice.equals("checkbox1")){
			playerChoice = "Paper";
			if(compChoice.equals("Scissors") || compChoice.equals("Lizard")){
				result = compChoice + " beats " + playerChoice;
				cScore++;
			}else if(playerChoice.equals(compChoice)){
				result = "It's a tie for this round!";
			}else{
				result = playerChoice +" beats "+compChoice;
				pScore++;
			}
		//SCISSORS
		}else if(playerChoice.equals("checkbox2")){
			playerChoice = "Scissors";
			if(compChoice.equals("Spock") || compChoice.equals("Rock")){
				result = compChoice + " beats " + playerChoice;
				cScore++;
			}else if(playerChoice.equals(compChoice)){
				result = "It's a tie for this round!";
			}else{
				result = playerChoice +" beats "+compChoice;
				pScore++;
			}
		//LIZARD
		}else if(playerChoice.equals("checkbox3")){
			playerChoice = "Lizard";
			if(compChoice.equals("Rock") || compChoice.equals("Scissors")){
				result = compChoice + " beats " + playerChoice;
				cScore++;
			}else if(playerChoice.equals(compChoice)){
				result = "It's a tie for this round!";
			}else{
				result = playerChoice +" beats "+compChoice;
				pScore++;
			}
		//SPOCK
		}else if(playerChoice.equals("checkbox4")){
			playerChoice = "Spock";
			if(compChoice.equals("Lizard") || compChoice.equals("Paper")){
				result = compChoice + " beats " + playerChoice;
				cScore++;
			}else if(playerChoice.equals(compChoice)){
				result = "It's a tie for this round!";
			}else{
				result = playerChoice +" beats "+compChoice;
				pScore++;
			}
		}else{
			result = "no choice selected!";
		}
		
		return result;
	}
	
	// post game pop-out dialog, no button though,so more like a prompt
	
	protected void gameOver() {
		
		
		
		if(pScore ==5){
			sticky = new Dialog(this, "Game Over! YOU WIN!");
		}else{
			sticky = new Dialog(this, "Game Over! COMPUTER WINS!");
		}

		sticky.addWindowListener(new WindowListener(){
		@Override
		public void windowOpened(WindowEvent e) {
			// do nothing
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// do nothing
			sticky.dispose();
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// do nothing
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// do nothing
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// do nothing
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// do nothing
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// do nothing
			
		}
		
	});
		sticky.setSize(300, 50);
		sticky.setVisible(true);
		cScore = 0;
		pScore = 0;
	}
	
	
	
	//main
	public static void main( String[] args){
		Game game = new Game();
	}

}

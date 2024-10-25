
import java.util.Scanner;
import java.util.Random;

public class main {
	
	public static int fontset_size=80;
	static short start_addr=0x200; 
	 
public static void main(String []args) {
	
	
	
	System.out.print("Welcome to Chip8 emulator");
chip_8 chip=new chip_8();
System.out.print("the memory has been loaded successfully");


}
	
}



class chip_8{
	
	Random random=new Random();
	int rand_val=random.nextInt(256); // to get a value from 0 to 255 (byte)
	byte x= (byte)rand_val;
	
	//Initializing all elements
	short[] Stack; //16 address (spaces)
	short[] MEM;//4096x16
	short PC=0x20;
	short AR; //address register
	byte[] keys; //16 keys 1 to f
	byte delaytimer;
	byte soundtimer;
	int [] Screen;
	short opcode;
	byte SP;
	
	static byte []Font_set= {
			 (byte) 0xF0, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0xF0, // 0
		        (byte) 0x20, (byte) 0x60, (byte) 0x20, (byte) 0x20, (byte) 0x70, // 1
		        (byte) 0xF0, (byte) 0x10, (byte) 0xF0, (byte) 0x80, (byte) 0xF0, // 2
		        (byte) 0xF0, (byte) 0x10, (byte) 0xF0, (byte) 0x10, (byte) 0xF0, // 3
		        (byte) 0x90, (byte) 0x90, (byte) 0xF0, (byte) 0x10, (byte) 0x10, // 4
		        (byte) 0xF0, (byte) 0x80, (byte) 0xF0, (byte) 0x10, (byte) 0xF0, // 5
		        (byte) 0xF0, (byte) 0x80, (byte) 0xF0, (byte) 0x90, (byte) 0xF0, // 6
		        (byte) 0xF0, (byte) 0x10, (byte) 0x20, (byte) 0x40, (byte) 0x40, // 7
		        (byte) 0xF0, (byte) 0x90, (byte) 0xF0, (byte) 0x90, (byte) 0xF0, // 8
		        (byte) 0xF0, (byte) 0x90, (byte) 0xF0, (byte) 0x10, (byte) 0xF0, // 9
		        (byte) 0xF0, (byte) 0x90, (byte) 0xF0, (byte) 0x90, (byte) 0x90, // A
		        (byte) 0xE0, (byte) 0x90, (byte) 0xE0, (byte) 0x90, (byte) 0xE0, // B
		        (byte) 0xF0, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0xF0, // C
		        (byte) 0xE0, (byte) 0x90, (byte) 0x90, (byte) 0x90, (byte) 0xE0, // D
		        (byte) 0xF0, (byte) 0x80, (byte) 0xF0, (byte) 0x80, (byte) 0xF0, // E
		        (byte) 0xF0, (byte) 0x80, (byte) 0xF0, (byte) 0x80, (byte) 0x80  // F
	};
	//FontSet start_addr=0x50
	chip_8(){
		
		PC=0x200;
		for(int i=0;i<80;i++) { 
			MEM[0x50+i]=Font_set[i];
		}
	}
	void OP_00E0() { //clear	
	//we would use memset here if it worked on fucking java 	
	}
	
	void OP_00EE() { //return op
		--SP;
		PC=Stack[SP];	
		} 
	
	void OP_1nnn() {//jmp op
	short address= (short) (opcode & 0x0FFF);
	PC=address;
	}
	
	void OP_2nnn() {// call subroutine
		
		
	} 
}

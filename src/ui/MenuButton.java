package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import utilz.LoadSave;
import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
	// TODO: create private fields
	// TODO: int xPos, yPos, rowIndex, index
	// TODO: xOffsetCenter set to B_WIDTH / 2
	// TODO: Gamestate called state
	// TODO: BufferedImage[] imgs
	// TODO: boolean mouseOver, mousePressed
	// TODO: Rectangle bounds

	public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		initBounds();
		// TODO: set this xPos to xPos
		// TODO: set this yPos to yPos
		// TODO: set this rowIndex to rowIndex
		// TODO: set this state to state
		// TODO: call loadImgs()
		// TODO: call initBounds()
	}

	private void initBounds() {
		bounds = newRectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
	}

	private void loadImgs() {
		// TODO: set img to new BufferedImage[3];
		// TODO: create a BufferedImage called temp and set to LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS)
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}

	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);

	}

	public void update() {
		index = 0;
		if (isMouseOver()) {
			index = 1;
		}
		if (isMousePressed()) {
			index = 2;
		}
		// TODO: set index to 0
		// TODO if mouseOver
		// TODO: set index to 1
		// TODO: end of if statement
		// TODO: if mousePressed
		// TODO: set index to 2
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void applyGamestate() {
		Gamestate.state = state;
	}

	public void resetBools() {
		mouseOver, mousePressed = false;
	}

}

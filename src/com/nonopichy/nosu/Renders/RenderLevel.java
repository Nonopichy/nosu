package com.nonopichy.nosu.Renders;

import com.nonopichy.nosu.Game;
import com.nonopichy.nosu.Level;

import java.awt.*;

public class RenderLevel {

    public int largura;
    public int altura;
    public Level level;

    public Image background;
    public Color Opacity;

    public RenderLevel(int largura, int altura, Level level, int opacity){
        this.largura = largura;
        this.altura = altura;
        this.level = level;

        this.Opacity = new Color(0, 0, 0, opacity);

        refresh();
    }

    public void render(Graphics g){
        if (!validLevel())
            return;
        if(background==null) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, largura, altura);
        }else{
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(background, 0,0, largura,altura, Game.game);
            g2.setColor(Opacity);
            g2.fillRect(0, 0, largura, altura);
        }

        g.setColor(Color.GREEN);
        g.fillRect(10, 10, Game.life, 10);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.ITALIC, 16));
        g.drawString("Points: " + Game.pontuacao, 5, 470);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.ITALIC, 16));
        g.drawString("Combo: " + Game.combo, 5, 455);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.ITALIC, 16));
     //   g.drawString("[DeBug] Now: " + level.now + ", Timer:" + level.timer + ", N: " + level.n
       //         + "Rec.size: " + level.rec.size() + ", Preview.size: " +level.preview.size() + ", RealFrame: " + level.real_frames[0], 5, 30);

        double one =  (300 * Game.boas + 100 * Game.meidas + 50 * Game.ruins);
        double two = (300 * (Game.boas + Game.meidas + Game.ruins + Game.falha));

        double Accuracy = 100;

        if (two != 0){
            Accuracy = (one / two) * 100;
        }

        g.setFont(new Font("Arial", Font.ITALIC, 32));
        g.drawString("Precisao: " + Accuracy+"%", 50, 350);
        g.setColor(Color.YELLOW);

        level.render(g);
    }

    public void refresh(){
        if (!validLevel())
            return;
        this.background = level.background;
    }

    public Boolean validLevel(){
        if(level==null)
            return false;
        if(level.ready==true)
            return true;
        return false;
    }

    public void update(){
        if(!validLevel())
            return;
        level.update();

        if(Game.life < 1)
            Game.life = 200;
        else if (Game.life > 200)
            Game.life = 200;


    }

    public void setLevel(Level level){
        this.level = level;
        refresh();
    }

    public void setOpacity(int opacity){
        this.Opacity = new Color(0, 0, 0, opacity);
    }
}

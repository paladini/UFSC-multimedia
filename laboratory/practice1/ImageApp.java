
import java.awt.image.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// Equipe:
// 		Evandro Sperfeld Coan
// 		Fernando Paladini

public class ImageApp   {
	
	// Leitura da imagem
	public static BufferedImage loadImage(String surl) {  
		BufferedImage bimg = null;  
		try {  
			URL url = new URL(surl);
			bimg = ImageIO.read(url);  
			//bimg = ImageIO.read(new File("D:/Temp/mundo.jpg"));
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return bimg;  
	}  
	
	public void apresentaImagem(JFrame frame, BufferedImage img) {
		frame.setBounds(0, 0, img.getWidth(), img.getHeight());
		JImagePanel panel = new JImagePanel(img, 0, 0);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static BufferedImage criaImagemRGB() {
		BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

		WritableRaster raster = img.getRaster();
		
		for(int h=0;h<200;h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<200;w++) {//refere-se a imagem amarela
				raster.setSample(w,h,0,220); // Componente Vermelho
				raster.setSample(w,h,1,219); // Componente Verde
				raster.setSample(w,h,2,97);  // Componente Azul
			} 
		return img;
	}
	
	public static BufferedImage reduzirImagem(BufferedImage antiga) {
		BufferedImage imgReduzida = new BufferedImage(antiga.getWidth()/2, antiga.getHeight()/2, BufferedImage.TYPE_INT_RGB);
		
		WritableRaster raster = antiga.getRaster();
		WritableRaster rasterReduzido = imgReduzida.getRaster();
		
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				rasterReduzido.setSample(w/2, h/2, 0, raster.getSample(w, h, 0));
				rasterReduzido.setSample(w/2, h/2, 1, raster.getSample(w, h, 1));
				rasterReduzido.setSample(w/2, h/2, 2, raster.getSample(w, h, 2));
			}
		
		return imgReduzida;
	}
	
	public static BufferedImage criarTonsDeCinza(BufferedImage antiga) {
		BufferedImage imagem = new BufferedImage(antiga.getWidth(), antiga.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = imagem.getRaster();
		
		// 0.3R + 0.59G + 0.11B/
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				int rgb = antiga.getRGB(w,h);
				int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
				int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
				int b = (int)(rgb&0x000000FF); //componente azul
				int cinza = (int)(0.3*r + 0.59*g + 0.11*b);
				
				raster.setSample(w, h, 0, cinza);
			}
		
		return imagem;
	}
	
	public static BufferedImage converterTonsDeCinzaParaBinario(BufferedImage antiga) {
		
		BufferedImage imagem = new BufferedImage(antiga.getWidth(), antiga.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		WritableRaster raster = imagem.getRaster();
		
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				if (antiga.getRaster().getSample(w, h, 0) >= 127) {
					raster.setSample(w, h, 0, 1);
				} else {
					raster.setSample(w, h, 0, 0);
				}
			}
		
		return imagem;
	}
	
	public static BufferedImage pegarR(BufferedImage antiga) {
		
		BufferedImage imagem = new BufferedImage(antiga.getWidth(), antiga.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = imagem.getRaster();
		
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				int rgb = antiga.getRGB(w,h);
				int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
				raster.setSample(w, h, 0, r);
			}
		
		return imagem;
	}
	
	public static BufferedImage pegarG(BufferedImage antiga) {
		
		BufferedImage imagem = new BufferedImage(antiga.getWidth(), antiga.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = imagem.getRaster();
		
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				int rgb = antiga.getRGB(w,h);
				int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
				raster.setSample(w, h, 0, g);
			}
		
		return imagem;
	}

	public static BufferedImage pegarB(BufferedImage antiga) {
	
		BufferedImage imagem = new BufferedImage(antiga.getWidth(), antiga.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = imagem.getRaster();
		
		for(int h=0;h<antiga.getTileWidth();h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<antiga.getHeight(); w++) {//refere-se a imagem amarela
				int rgb = antiga.getRGB(w,h);
				int b = (int)(rgb&0x000000FF); //componente azul
				raster.setSample(w, h, 0, b);
			}
		
		return imagem;
	}
	
	
	
	public static BufferedImage criaImagemCinza() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<256;h++)
			for(int w=0;w<256;w++) {
				raster.setSample(w,h,0,h);//como o h = 0 e vai aumentando, cada linha vai ficando mais clara
			}
		return img;
	}
	
	public static BufferedImage criaImagemBinaria() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_BINARY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<256;h++)
			for(int w=0;w<256;w++) {
				if (((h/50)+(w/50)) % 2 == 0) 
					raster.setSample(w,h,0,0); // checkerboard pattern.
				else raster.setSample(w,h,0,1); 
			}
		return img;
	}
	
	// Imprime valores dos pixeis de imagem RGB
	public static void  imprimePixeis(BufferedImage bufferedImage) {
		// Get a pixel
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		
		for(int h=0;h<height;h++)
			for(int w=0;w<width;w++) {
				int rgb = bufferedImage.getRGB(w,h);
				int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
				int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
				int b = (int)(rgb&0x000000FF); //componente azul
				System.out.print("at ("+w+","+h+"): ");
				System.out.println(r+","+g+","+b);
			}
	}

	public static void main(String[] args) {
		ImageApp ia = new ImageApp();
		
		// Professor
		BufferedImage imgJPEG = loadImage("http://www.inf.ufsc.br/~willrich/INE5431/RGB.jpg");
//		BufferedImage imgRGB = criaImagemRGB();
//		BufferedImage imgCinza = criaImagemCinza();
//		BufferedImage imgBinaria = criaImagemBinaria();
		ia.apresentaImagem(new JFrame("imgJPEG"), imgJPEG);
//		ia.apresentaImagem(new JFrame("imgRGB"), imgRGB);
//		ia.apresentaImagem(new JFrame("imgCinza"), imgCinza);
//		ia.apresentaImagem(new JFrame("imgBinaria"), imgBinaria);

		// Imagem reduzida
		BufferedImage imgJPEG_reduzida = ImageApp.reduzirImagem(imgJPEG);
		ia.apresentaImagem(new JFrame("imgJPEG_reduzida"), imgJPEG_reduzida);
		
		// Tons de cinza
		BufferedImage imgJPEG_cinza = ImageApp.criarTonsDeCinza(imgJPEG);
		ia.apresentaImagem(new JFrame("imgJPEG_criarTonsDeCinza"), imgJPEG_cinza);
		
		// Imagem binaria
		BufferedImage imgJPEG_binaria = ImageApp.converterTonsDeCinzaParaBinario(ImageApp.criarTonsDeCinza(imgJPEG));
		ia.apresentaImagem(new JFrame("imgJPEG_converterTonsDeCinzaParaBinario"), imgJPEG_binaria);
		
		// Separar em canais
		BufferedImage imgJPEG_r = ImageApp.pegarR(imgJPEG);
		BufferedImage imgJPEG_g = ImageApp.pegarG(imgJPEG);
		BufferedImage imgJPEG_b = ImageApp.pegarB(imgJPEG);
		ia.apresentaImagem(new JFrame("imgJPEG_r"), imgJPEG_r);
		ia.apresentaImagem(new JFrame("imgJPEG_g"), imgJPEG_g);
		ia.apresentaImagem(new JFrame("imgJPEG_b"), imgJPEG_b);
		
		imprimePixeis(imgJPEG);
	}
}
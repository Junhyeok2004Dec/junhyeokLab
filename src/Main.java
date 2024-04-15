import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class MorseCodeKeyer extends JFrame {
	private JTextArea textArea;
	private JButton playButton;

	private final Map<Character, String> morseCodeMap;

	public MorseCodeKeyer() {
		morseCodeMap = createMorseCodeMap();

		setTitle("Morse Code Keyer");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea = new JTextArea();
		playButton = new JButton("Play Morse Code");

		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputText = textArea.getText().toUpperCase();
				playMorseCode(inputText);
			}
		});

		setLayout(new BorderLayout());
		add(textArea, BorderLayout.CENTER);
		add(playButton, BorderLayout.SOUTH);
	}

	private Map<Character, String> createMorseCodeMap() {
		Map<Character, String> map = new HashMap<>();
		map.put('A', ".-");
		map.put('B', "-...");
		map.put('C', "-.-.");
		map.put('D', "-..");
		map.put('E', ".");
		map.put('F', "..-.");
		map.put('G', "--.");
		map.put('H', "....");
		map.put('I', "..");
		map.put('J', ".---");
		map.put('K', "-.-");
		map.put('L', ".-..");
		map.put('M', "--");
		map.put('N', "-.");
		map.put('O', "---");
		map.put('P', ".--.");
		map.put('Q', "--.-");
		map.put('R', ".-.");
		map.put('S', "...");
		map.put('T', "-");
		map.put('U', "..-");
		map.put('V', "...-");
		map.put('W', ".--");
		map.put('X', "-..-");
		map.put('Y', "-.--");
		map.put('Z', "--..");
		map.put('1', ".----");
		map.put('2', "..---");
		map.put('3', "...--");
		map.put('4', "....-");
		map.put('5', ".....");
		map.put('6', "-....");
		map.put('7', "--...");
		map.put('8', "---..");
		map.put('9', "----.");
		map.put('0', "-----");
		return map;
	}

	private void playMorseCode(String inputText) {
		try {
			Clip clip = AudioSystem.getClip();
			AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
			AudioInputStream audioInputStream = new AudioInputStream(new ByteArrayInputStream(encodeToAudio(inputText)), format, inputText.length());
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] encodeToAudio(String inputText) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			for (char c : inputText.toCharArray()) {
				if (c == ' ') {
					appendSilence(outputStream, 200);
				} else if (morseCodeMap.containsKey(c)) {
					String morseCode = morseCodeMap.get(c);
					for (char morseChar : morseCode.toCharArray()) {
						if (morseChar == '.') {
							appendSound(outputStream, 100);
						} else if (morseChar == '-') {
							appendSound(outputStream, 300);
						}
						appendSilence(outputStream, 100);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputStream.toByteArray();
	}

	private void appendSound(ByteArrayOutputStream outputStream, int duration) throws IOException {
		for (int i = 0; i < duration * 44100 / 1000; i++) {
			short val = (short) (32767.0 * 0.5 * Math.sin(2.0 * Math.PI * 400.0 * i / 44100.0));
			outputStream.write(val & 0xFF);
			outputStream.write((val >> 8) & 0xFF);
		}
	}

	private void appendSilence(ByteArrayOutputStream outputStream, int duration) throws IOException {
		for (int i = 0; i < duration * 44100 / 1000; i++) {
			outputStream.write(0);
			outputStream.write(0);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MorseCodeKeyer keyer = new MorseCodeKeyer();
			keyer.setVisible(true);
		});
	}
}

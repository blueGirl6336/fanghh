package hitwh.fanghh.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/*
 * 更改生成的dao和xml文件内容和文件名
 */
public class ModifyFile
{
	public static void main(String[] args)
	{
		String xmlLocation = "lib/generatorConfig.xml";
		File xmlFile = new File(xmlLocation);
		Document document = null;
		try
		{
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
		} catch (SAXException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		} catch (ParserConfigurationException e1)
		{
			e1.printStackTrace();
		}

		Element root = document.getDocumentElement();
		Element contextElement = (Element) root.getElementsByTagName("context").item(0);

		Element daoElement = (Element) contextElement.getElementsByTagName("javaClientGenerator").item(0);
		Element mappingElement = (Element) contextElement.getElementsByTagName("sqlMapGenerator").item(0);

		String srcFolderName = "lib/" + daoElement.getAttribute("targetProject");
		String daoFolderName = daoElement.getAttribute("targetPackage").replace(".", "/");
		String mappingFolderName = mappingElement.getAttribute("targetPackage").replace(".", "/");

		File daoFolderFile = new File(srcFolderName + "/" + daoFolderName);
		File mappingFolderFile = new File(srcFolderName + "/" + mappingFolderName);

		if (daoFolderFile.isDirectory())
		{
			File[] list = daoFolderFile.listFiles();

			int count = 0;

			for (File file : list)
			{
				String name = file.getName();
				if (name.substring(name.length() - 11, name.length() - 5).equals("Mapper"))
				{
					String newName = null;
					System.out.print("dao name:" + name);
					StringBuffer stringBuffer = new StringBuffer(name);
					newName = stringBuffer.replace(stringBuffer.length() - 11, stringBuffer.length() - 5, "Dao")
							.toString();
					System.out.println("->" + newName);

					try
					{
						boolean lock = false;
						StringBuilder stringBuilder = new StringBuilder();
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						String string = null;
						while ((string = bufferedReader.readLine()) != null)
						{
							if (!lock && string.contains(name.substring(0, name.length() - 5)))
							{
								string = string.replaceAll(name.substring(0, name.length() - 5),
										newName.substring(0, newName.length() - 5));
								lock = true;
							}
							stringBuilder.append(System.lineSeparator() + string);
						}

						BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
						bufferedWriter.write(stringBuilder.toString());
						bufferedWriter.flush();

						bufferedReader.close();
						bufferedWriter.close();
					} catch (Exception e)
					{
						e.printStackTrace();
					}

					file.renameTo(new File(daoFolderFile, newName));
					count++;
				}
			}
			System.out.println("dao num:" + count);
		} else
		{
			System.out.println("daoFolderName error" + daoFolderName);
		}

		if (mappingFolderFile.isDirectory())
		{
			File[] list = mappingFolderFile.listFiles();

			int count = 0;
			for (File file : list)
			{
				String name = file.getName();
				System.out.println("xml:" + name);
				if (name.substring(name.length() - 10, name.length() - 4).equals("Mapper"))
				{
					String newName = null;
					StringBuffer stringBuffer = new StringBuffer(name);
					newName = stringBuffer.replace(stringBuffer.length() - 10, stringBuffer.length() - 4, "Dao")
							.toString();

					try
					{
						boolean lock = false;
						StringBuilder stringBuilder = new StringBuilder();
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						String string = null;
						while ((string = bufferedReader.readLine()) != null)
						{
							if (!lock && string.contains(name.substring(0, name.length() - 4)))
							{
								string = string.replaceAll(name.substring(0, name.length() - 4),
										newName.substring(0, newName.length() - 4));
								lock = true;
							}
							stringBuilder.append(string + System.lineSeparator());
						}

						BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
						bufferedWriter.write(stringBuilder.toString());
						bufferedWriter.flush();

						bufferedReader.close();
						bufferedWriter.close();
					} catch (Exception e)
					{
						e.printStackTrace();
					}

					count++;
				}
			}
			System.out.println("xml num:" + count);
		} else
		{
			System.out.println("mappingFolderName error" + mappingFolderName);
		}
	}

}

package com.woosan.root.configuration;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3Util {

	private String accessKey = "AKIAYRKVC7P52J42ESUQ"; // ������ Ű
	private String secretKey = "z1/em0xASy8nvMRCbbU9/jLMuE6shfi1wtWuGUmC"; // ���� ������ Ű

	private AmazonS3 conn;

	@SuppressWarnings("deprecation")
	public S3Util() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);
		this.conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint("s3.ap-northeast-2.amazonaws.com"); // ��������Ʈ ���� [ �ƽþ� ����� ���� ]
	}

	// ��Ŷ ����Ʈ�� �������� �޼����̴�.
	public List<Bucket> getBucketList() {
		return conn.listBuckets();
	}

	// ��Ŷ�� �����ϴ� �޼����̴�.
	public Bucket createBucket(String bucketName) {
		return conn.createBucket(bucketName);
	}

	// ���� ���� (������ ���ϸ� �ڿ� "/"�� �ٿ����Ѵ�.)
	public void createFolder(String bucketName, String folderName) {
		conn.putObject(bucketName, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
	}

	// ���� ���ε�
	public void fileUpload(String bucketName, String fileName, byte[] fileData) throws FileNotFoundException {

		String filePath = (fileName).replace(File.separatorChar, '/'); // ���� �����ڸ� `/`�� ����(\->/) �̰� ������ / ��� �Ѿ���鼭 \�� �ٲ�� �Ű���.
		ObjectMetadata metaData = new ObjectMetadata();

		metaData.setContentLength(fileData.length);   //��Ÿ������ ���� -->������ 128kB���� ���ε� ���������� ����ũ�⸸ŭ ���۸� �������״�.
	    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileData); //���� ����

		conn.putObject(bucketName, filePath, byteArrayInputStream, metaData);

	}

	// ���� ����
	public void fileDelete(String bucketName, String fileName) {
		String imgName = (fileName).replace(File.separatorChar, '/');
		conn.deleteObject(bucketName, imgName);
		System.out.println("��������");
	}

	// ���� URL
	public String getFileURL(String bucketName, String fileName) {
		System.out.println("�Ѿ���� ���ϸ� : "+fileName);
		String imgName = (fileName).replace(File.separatorChar, '/');
		return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, imgName)).toString();
	}
}

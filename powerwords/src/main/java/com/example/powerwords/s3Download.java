/*
package com.example.powerwords;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

@Component
public class s3Download implements CommandLineRunner {

	@Override
	public void run(String... args) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

		try {
			// S3�̃I�u�W�F�N�g���擾����
			S3Object o = s3.getObject("�o�P�b�g��", "�I�u�W�F�N�g��");
			S3ObjectInputStream s3is = o.getObjectContent();

			// �_�E�����[�h��̃t�@�C���p�X���w�肷��
			FileOutputStream fos = new FileOutputStream(new File("�t�@�C���p�X"));

			// S3�̃I�u�W�F�N�g��1024byte���ǂݍ��݁A�_�E�����[�h��̃t�@�C���ɏ�������
			byte[] read_buf = new byte[1024];
			int read_len = 0;
			while ((read_len = s3is.read(read_buf)) > 0) {
				fos.write(read_buf, 0, read_len);
			}
			s3is.close();
			fos.close();
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("Done!");
	}
}
*/
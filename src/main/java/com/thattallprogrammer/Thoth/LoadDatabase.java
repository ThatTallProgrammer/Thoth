package com.thattallprogrammer.Thoth;

import com.thattallprogrammer.Thoth.cci.Cci;
import com.thattallprogrammer.Thoth.cci.CciRepository;
import com.thattallprogrammer.Thoth.cci.reference.CciReference;
import com.thattallprogrammer.Thoth.cci.reference.CciReferenceRepository;
import com.thattallprogrammer.Thoth.checklist.Checklist;
import com.thattallprogrammer.Thoth.checklist.ChecklistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class LoadDatabase
{
  private static Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(
      CciRepository cciRepository,
      CciReferenceRepository cciReferenceRepository,
      ChecklistRepository checklistRepository
  )
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    return args -> {
      Cci cci = new Cci(
          "CCI-000002",
          "draft",
          dateFormat.parse("2009-09-14"),
          "DISA FSO",
          "policy",
          "Record of distribution history of access control policy",
          "The organization disseminates the access control policy to organization-defined personnel or roles.",
          "The policy will address purpose, scope, roles, responsibilities, management commitment, coordination " +
              "among organizational entities, and compliance."
      );

      CciReference ref1 = new CciReference(
          "AC-1 a",
          "NIST",
          "NIST SP 800-53",
          "3",
          "http://csrc.nist.gov/publications/PubsSPs.html"
      );
      CciReference ref2 = new CciReference(
          "AC-1.1 (iii)",
          "NIST",
          "NIST SP 800-53A",
          "1",
          "http://csrc.nist.gov/publications/PubsSPs.html"
      );
      CciReference ref3 = new CciReference(
          "AC-1 a 1",
          "NIST",
          "NIST SP 800-53 Revision 4",
          "4",
          "http://csrc.nist.gov/publications/PubsSPs.html"
      );

      logger.info("Preloading " + cciReferenceRepository.saveAll(Arrays.asList(ref1, ref2, ref3)));

      cci.getReferences().addAll(Arrays.asList(ref1, ref2, ref3));

      logger.info("Preloading " + cciRepository.save(cci));

      Checklist checklist = new Checklist(
          "Active_Directory",
          dateFormat.parse("2009-01-20"),
          "Active Directory Security Checklist",
          "Checklist for securing Active Directory",
          "",
          "Release 3",
          "2"
      );

      logger.info("Preloading " + checklistRepository.save(checklist));
    };
  }
}
